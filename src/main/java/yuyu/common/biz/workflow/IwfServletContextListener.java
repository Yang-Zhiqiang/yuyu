package yuyu.common.biz.workflow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSON;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.plugins.server.servlet.ListenerBootstrap;
import org.jboss.resteasy.spi.Registry;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;

/**
 *
 * サーブレット起動時にJAX-RSアノテーションをスキャンするため、ServletContextListenerを実装します。<br>
 * web.xmlのListenerタグで当クラスを登録してください。
 */
public class IwfServletContextListener implements javax.servlet.ServletContextListener {

    private static Logger LOGGER = LoggerFactory.getLogger(IwfServletContextListener.class);

    protected ResteasyDeployment deployment;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();

        ListenerBootstrap config = new ListenerBootstrap(event.getServletContext()) {

            @Override
            public URL[] getScanningUrls() {

                List<URL> urllist = new ArrayList<URL>();
                for (URL url : super.getScanningUrls()) {

                    LOGGER.debug("URL : "+ url.toString());
                    if(url.toString().matches("jndi:.*iwfclient.*\\.jar$") || url.toString().matches("jndi:.*yuyu.*\\.jar$")){
                        urllist.add(url);
                    }else if(url.toString().matches("file:.*")){
                        urllist.add(url);
                    }

                }
                LOGGER.debug(JSON.encode(urllist, true));
                return urllist.toArray(new URL[0]);
            }

        };
        deployment = config.createDeployment();
        deployment.start();

        servletContext.setAttribute(ResteasyProviderFactory.class.getName(), deployment.getProviderFactory());
        servletContext.setAttribute(Dispatcher.class.getName(), deployment.getDispatcher());
        servletContext.setAttribute(Registry.class.getName(), deployment.getRegistry());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        deployment.stop();
    }
}
