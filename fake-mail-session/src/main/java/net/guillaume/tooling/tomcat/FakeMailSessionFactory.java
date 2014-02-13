package net.guillaume.tooling.tomcat;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

public class FakeMailSessionFactory implements ObjectFactory {

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {

        System.out.println("FakeMailSessionFactory : " + obj);
        // todo : not implemented yet

        return null;
    }

}
