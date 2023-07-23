package yuyu.infr.objstorage;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.co.slcs.swak.objstorage.FileSystemObjStorageManager;
import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * ファイルシステム・オブジェクトストレージマネージャ
 */
@Singleton
public class YuyuObjStorageManager extends FileSystemObjStorageManager {

    @Inject
    private YuyuBaseConfig config;

    @Override
    protected File getBaseDir() {
        return new File(config.getObjStorageDir());
    }

    @Override
    protected String getFileName(String id) {
        return id + ".obj";
    }

}
