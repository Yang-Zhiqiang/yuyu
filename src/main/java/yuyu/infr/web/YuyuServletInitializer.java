package yuyu.infr.web;

import java.sql.SQLException;

import javax.inject.Singleton;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.web.servlet.ServletInitializer;

import org.h2.tools.Server;

/**
 * Servlet 初期化処理クラスです。<br />
 * Servlet 起動時・終了時に特別な処理が必要な場合、このクラスに記述します。
 */
@Singleton
public class YuyuServletInitializer implements ServletInitializer {

    private Server pgServer = null;

    @Override
    public void init() {
        try {
            pgServer = Server.createPgServer("-baseDir", SWAK.getApplicationRootPath() + "/../../../db/h2db");
            pgServer.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        if (pgServer != null) {
            pgServer.stop();
        }
    }

}
