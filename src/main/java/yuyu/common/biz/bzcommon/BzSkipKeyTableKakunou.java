package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 共通 スキップキーテーブル格納処理
 */
public class BzSkipKeyTableKakunou {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BizDomManager bizDomManager;

    public BzSkipKeyTableKakunou() {
        super();
    }

    public void exec() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);

        String misetteiKomokumei = "";

        boolean errorFlag = false;

        String recoverySikibetukey = null;

        String syuturyokuMegHikisuu = "";

        BT_SkipKey skipKey = new BT_SkipKey();


        if (BizUtil.isBlank(bzRecoveryDatasikibetuBean.getIbKakutyoujobcd())) {

            misetteiKomokumei = "「（ＩＢ）拡張ジョブコード」";

            errorFlag = true;
        }

        if (BizUtil.isBlank(bzRecoveryDatasikibetuBean.getIbTableid())) {

            misetteiKomokumei = misetteiKomokumei + "「（ＩＢ）テーブルＩＤ」";

            errorFlag = true;
        }

        if (BizUtil.isBlank(bzRecoveryDatasikibetuBean.getIbRecoveryfilterid())) {

            misetteiKomokumei = misetteiKomokumei + "「（ＩＢ）リカバリフィルタＩＤ」";

            errorFlag = true;
        }

        if (BizUtil.isBlank(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1())) {

            misetteiKomokumei = misetteiKomokumei + "「（ＩＢ）リカバリフィルタキー１」";

            errorFlag = true;
        }

        if (errorFlag) {

            syuturyokuMegHikisuu = "拡張ジョブコード＝ " + bzRecoveryDatasikibetuBean.getIbKakutyoujobcd() + " ,  " +
                "テーブルＩＤ＝ " + bzRecoveryDatasikibetuBean.getIbTableid() + " ,  " +
                "リカバリフィルタＩＤ＝ " + bzRecoveryDatasikibetuBean.getIbRecoveryfilterid() + " ,  " +
                "リカバリフィルタキー１＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1() + " ,  " +
                "リカバリフィルタキー２＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2() + " ,  " +
                "リカバリフィルタキー３＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey3() + " ,  " +
                "リカバリフィルタキー４＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey4() + " ,  " +
                "リカバリフィルタキー５＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey5();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBA1003, misetteiKomokumei, syuturyokuMegHikisuu));

            return;
        }

        recoverySikibetukey = getRecoverySikibetukey(bzRecoveryDatasikibetuBean);

        if (bizDomManager.getSkipKey(recoverySikibetukey) != null) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBA1004, recoverySikibetukey));

            return;
        }

        skipKey.setRecoverysikibetukey(recoverySikibetukey);

        skipKey.setKakutyoujobcd(bzRecoveryDatasikibetuBean.getIbKakutyoujobcd());

        skipKey.setTableid(bzRecoveryDatasikibetuBean.getIbTableid());

        skipKey.setRecoveryfilterid(bzRecoveryDatasikibetuBean.getIbRecoveryfilterid());

        skipKey.setRecoveryfilterkey1(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1());

        skipKey.setRecoveryfilterkey2(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2());

        skipKey.setRecoveryfilterkey3(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey3());

        skipKey.setRecoveryfilterkey4(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey4());

        skipKey.setRecoveryfilterkey5(bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey5());

        ExDBTransactionalUtil.insert(skipKey);

        syuturyokuMegHikisuu = "拡張ジョブコード＝ " + bzRecoveryDatasikibetuBean.getIbKakutyoujobcd() + " ,  " +
            "テーブルＩＤ＝ " + bzRecoveryDatasikibetuBean.getIbTableid() + " ,  " +
            "リカバリフィルタＩＤ＝ " + bzRecoveryDatasikibetuBean.getIbRecoveryfilterid() + " ,  " +
            "リカバリフィルタキー１＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1() + " ,  " +
            "リカバリフィルタキー２＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2() + " ,  " +
            "リカバリフィルタキー３＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey3() + " ,  " +
            "リカバリフィルタキー４＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey4() + " ,  " +
            "リカバリフィルタキー５＝" + bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey5();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA1005, syuturyokuMegHikisuu));
    }

    public String getRecoverySikibetukey(BzRecoveryDatasikibetuBean pBzRecoveryDatasikibetuBean) {


        String recoverySkbtkey = "";

        String setuzokune = "_";

        String ibKakutyoujobcd = pBzRecoveryDatasikibetuBean.getIbKakutyoujobcd();

        String ibTableid = pBzRecoveryDatasikibetuBean.getIbTableid();

        String ibRecoveryfilterid = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterid();

        String ibRecoveryfilterkey1 = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1();

        String ibRecoveryfilterkey2 = "";

        String ibRecoveryfilterkey3 = "";

        String ibRecoveryfilterkey4 = "";

        String ibRecoveryfilterkey5 = "";

        if (!BizUtil.isBlank(pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2())) {

            ibRecoveryfilterkey2 = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2();
        }

        if (!BizUtil.isBlank(pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey3())) {

            ibRecoveryfilterkey3 = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey3();
        }

        if (!BizUtil.isBlank(pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey4())) {

            ibRecoveryfilterkey4 = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey4();
        }

        if (!BizUtil.isBlank(pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey5())) {

            ibRecoveryfilterkey5 = pBzRecoveryDatasikibetuBean.getIbRecoveryfilterkey5();
        }

        recoverySkbtkey = ibKakutyoujobcd + setuzokune + ibTableid + setuzokune + ibRecoveryfilterid + setuzokune +
            ibRecoveryfilterkey1 + setuzokune + ibRecoveryfilterkey2 + setuzokune + ibRecoveryfilterkey3 + setuzokune +
            ibRecoveryfilterkey4 + setuzokune + ibRecoveryfilterkey5;

        return recoverySkbtkey;
    }
}
