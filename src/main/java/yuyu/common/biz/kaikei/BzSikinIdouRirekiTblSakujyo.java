package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;
import org.slf4j.Logger;

import yuyu.common.biz.kaikei.dba4bzsikinidourirekitblsakujyo.BzSikinIdouRirekiTblSakujyoDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BT_SikinIdouRireki;

/**
 * 業務共通 経理・会計 資金移動用履歴テーブル削除
 */
public class BzSikinIdouRirekiTblSakujyo {

    @Inject
    private BzSikinIdouRirekiTblSakujyoDao bzSikinIdouRirekiTblSakujyoDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public C_ErrorKbn trksKhData(String pSyono, String pHenKouSikiBetuKey) {

        logger.debug("▽ 契約保全データ取消処理 開始");

        List<BT_SikinIdouRireki> sikinIdouRirekiList =
            bzSikinIdouRirekiTblSakujyoDao.getBtSikinIdouRirekiItDelData(pSyono, pHenKouSikiBetuKey);

        C_ErrorKbn errorKbn = setSakujyoflg(sikinIdouRirekiList);

        logger.debug("△ 契約保全データ取消処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn trksHkkData(String pSyono, String pSkno, Integer pSkrrkno) {

        logger.debug("▽ 保険金データ取消処理 開始");

        List<BT_SikinIdouRireki> sikinIdouRirekiList =
            bzSikinIdouRirekiTblSakujyoDao.getBtSikinIdouRirekiJtDelDeta(pSyono, pSkno, pSkrrkno);

        C_ErrorKbn errorKbn = setSakujyoflg(sikinIdouRirekiList);

        logger.debug("△ 保険金データ取消処理 終了");

        return errorKbn;
    }

    private C_ErrorKbn setSakujyoflg(List<BT_SikinIdouRireki> pSikinIdouRirekiList) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pSikinIdouRirekiList.size() == 0) {
            errorKbn = C_ErrorKbn.ERROR;
        }
        else {
            for (BT_SikinIdouRireki wkSikinIdouRireki : pSikinIdouRirekiList) {
                wkSikinIdouRireki.setSakujyoflg(C_Delflag.SAKUJYO);

                bizDomManager.update(wkSikinIdouRireki);
            }
        }

        return errorKbn;
    }
}
