package com.sightcorner.shiro.util;


import org.apache.shiro.config.Ini;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.FactoryBean;

public class ChainDefinitionsSource implements FactoryBean<Ini.Section>{

    //从 xml 中传值
    private String filterChainDefinitions;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);

        if(null == section || section.isEmpty()) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }


        section.put("/**", "csrf,authc");

        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
