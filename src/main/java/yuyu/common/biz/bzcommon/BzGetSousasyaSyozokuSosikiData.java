package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.def.base.detacher.AM_SosikiDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Sosiki;

/**
 * 業務共通 共通 操作者所属組織情報取得クラス
 */
public class BzGetSousasyaSyozokuSosikiData {

    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager baseDomManager;

    public BzGetSousasyaSyozokuSosikiData() {
        super();
    }

    public BzGetSousasyaSyozokuSosikiDataBean exec(String pUserId) {

        logger.debug("▽ 操作者所属組織情報取得 開始");

        BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean =
            SWAKInjector.getInstance(BzGetSousasyaSyozokuSosikiDataBean.class);

        if (BizUtil.isBlank(pUserId)) {
            bzGetSousasyaSyozokuSosikiDataBean = null;
            logger.debug("△ 操作者所属組織情報取得 終了");

            return bzGetSousasyaSyozokuSosikiDataBean;
        }

        List<AM_Sosiki> sosikiLst = baseDomManager.getSosikisByUserId(pUserId);
        sosikiLst = AM_SosikiDetacher.detachSosikitouched(sosikiLst);

        if (sosikiLst.isEmpty()) {
            bzGetSousasyaSyozokuSosikiDataBean = null;
            logger.debug("△ 操作者所属組織情報取得 終了");

            return bzGetSousasyaSyozokuSosikiDataBean;
        }

        AM_Sosiki sosiki = sosikiLst.get(0);
        BeanUtil.copyProperties(bzGetSousasyaSyozokuSosikiDataBean, sosiki);

        logger.debug("△ 操作者所属組織情報取得 終了");

        return bzGetSousasyaSyozokuSosikiDataBean;
    }
}
