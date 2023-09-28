package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.ObjectUtil;
import jp.co.slcs.swak.util.bean.BeanUtil;


/**
 * 画面UiBeanのバックアップリストアユーティリティクラス
 */
public class BizUiBeanBackupUtil {

    public static <T extends Serializable> void backup(T uiBean, Object backupBean){
        Object tempBean = ObjectUtil.deepCopy(uiBean);
        BeanUtil.copyProperties(backupBean,  tempBean);
    }

    public static void restore(Object uiBean, Object backupBean){
        BeanUtil.copyProperties(uiBean,  backupBean);
    }
}
