package yuyu.common.biz.bznayose;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;

/**
 * 業務共通 名寄せ 取消用当日異動内容削除クラス
 */
public class BzTrksTjtIdouNaiyouSakujyo {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzTrksTjtIdouNaiyouSakujyo() {
        super();
    }

    public C_ErrorKbn exec(BzTrksTjtIdouNaiyouSakujyoBean pBzTrksTjtIdouNaiyouSakujyoBean) {

        logger.debug("▽ 取消用当日異動内容削除 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pBzTrksTjtIdouNaiyouSakujyoBean == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 取消用当日異動内容削除 終了");

            return errorKbn;

        }

        if (C_Huho2kyknoKbn.SYONO.eq(pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNoKbn())) {

            List<BT_TjtIdouNyKh> tjtIdouNyKhList = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno(
                pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNo(),
                pBzTrksTjtIdouNaiyouSakujyoBean.getYoukyuuNo());

            if (tjtIdouNyKhList.size() == 0) {

                errorKbn = C_ErrorKbn.ERROR;

            }
            else {
                bizDomManager.delete(tjtIdouNyKhList);

                errorKbn = C_ErrorKbn.OK;
            }

        }
        else if (C_Huho2kyknoKbn.MOSNO.eq(pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNoKbn())) {

            List<BT_TjtIdouNySk> tjtIdouNySkList = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno(
                pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNo(),
                pBzTrksTjtIdouNaiyouSakujyoBean.getYoukyuuNo());

            if (tjtIdouNySkList.size() == 0) {

                errorKbn = C_ErrorKbn.ERROR;
            }
            else {
                bizDomManager.delete(tjtIdouNySkList);

                errorKbn = C_ErrorKbn.OK;
            }
        }
        else if (C_Huho2kyknoKbn.NKSYSYNO.eq(pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNoKbn())) {

            List<BT_TjtIdouNyNk> tjtIdouNyNkList = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno(
                pBzTrksTjtIdouNaiyouSakujyoBean.getHuho2KykNo(),
                pBzTrksTjtIdouNaiyouSakujyoBean.getYoukyuuNo());

            if (tjtIdouNyNkList.size() == 0) {

                errorKbn = C_ErrorKbn.ERROR;
            }
            else {
                bizDomManager.delete(tjtIdouNyNkList);

                errorKbn = C_ErrorKbn.OK;
            }
        }
        else {
            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 取消用当日異動内容削除 終了");

        return errorKbn;
    }
}
