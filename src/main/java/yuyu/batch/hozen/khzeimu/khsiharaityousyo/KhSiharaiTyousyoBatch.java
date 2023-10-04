package yuyu.batch.hozen.khzeimu.khsiharaityousyo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khzeimu.khsiharaityousyo.dba.KhSiharaiTyousyoDao;
import yuyu.batch.hozen.khzeimu.khsiharaityousyo.dba.KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 税務 契約保全支払調書作成
 */
public class KhSiharaiTyousyoBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KhShrRireki";

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhSiharaiTyousyoDao khSiharaiTyousyoDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        try (ExDBResults<KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean> beanLst =
            khSiharaiTyousyoDao.getKhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmd(kakutyoujobCd, syoriYmd);
            EntityInserter<IT_KhTyousyo> khTyousyoIns = new EntityInserter<>();) {
            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            long shrtysyrenno = 0;
            String zenRecordSyono = "";
            long count = 0;
            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            String kinouId = khozenCommonParam.getFunctionId();
            String userId = khozenCommonParam.getUserID();
            String sysDateTime = BizDate.getSysDateTimeMilli();

            List<C_TtdktyuuiKbn> ttdktyuuiKbnLst1 = new ArrayList<>();
            ttdktyuuiKbnLst1.add(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
            ttdktyuuiKbnLst1.add(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
            ttdktyuuiKbnLst1.add(C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI);

            List<C_TtdktyuuiKbn> ttdktyuuiKbnLst2 = new ArrayList<>();
            ttdktyuuiKbnLst2.add(C_TtdktyuuiKbn.ADRHUMEI);
            ttdktyuuiKbnLst2.add(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI);
            ttdktyuuiKbnLst2.add(C_TtdktyuuiKbn.KAIGAITOKOU);

            List<C_TtdktyuuiKbn> ttdktyuuiKbnLst3 = new ArrayList<>();
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.ADRHUMEI);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.MINJISAISEI);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI);
            ttdktyuuiKbnLst3.add(C_TtdktyuuiKbn.KAIGAITOKOU);

            for (KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean bean : beanLst) {

                IT_KhShrRireki khShrRireki = bean.getIT_KhShrRireki();
                IT_KykSyouhn kykSyouhn = bean.getIT_KykSyouhn();
                IT_KykSya kykSya = bean.getIT_KykSya();
                IT_KykKihon kykKihon = bean.getIT_KykKihon();
                IT_HhknSya hhknSya = bean.getIT_HhknSya();
                IT_KhTtdkRireki khTtdkRireki = bean.getIT_KhTtdkRireki();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khShrRireki.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khShrRireki.getSyono());

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getSyouhnsdno());

                if (syouhnZokusei == null) {
                    throw new CommonBizAppException("商品属性マスタにデータが存在しません。商品コード：" +
                        kykSyouhn.getSyouhncd() + "　商品世代番号：" + kykSyouhn.getSyouhnsdno());
                }

                if (khShrRireki.getSyono().equals(zenRecordSyono)) {
                    shrtysyrenno++;
                }
                else {
                    shrtysyrenno = 1;
                }

                zenRecordSyono = khShrRireki.getSyono();

                C_TantouCdKbn tantouCdKbn = null;
                if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn())) {
                    tantouCdKbn = C_TantouCdKbn.KAIYAKU;
                }
                else if (C_ShrsyoriKbn.GENGAKU.eq(khShrRireki.getShrsyorikbn())) {
                    tantouCdKbn = C_TantouCdKbn.KEIYAKUHENKOU;
                }
                else if (C_ShrsyoriKbn.SBKAIJO.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.SBMENSEKI.eq(khShrRireki.getShrsyorikbn())) {
                    tantouCdKbn = C_TantouCdKbn.SIBOUTETUZUKI;
                }

                BM_TantouCd tantouCd = bizDomManager.getTantouCd(tantouCdKbn);
                if (tantouCd == null) {
                    throw new CommonBizAppException("担当コードマスタにデータが存在しません。担当コード：" + tantouCdKbn);
                }

                String kacd = tantouCd.getBusitucd();
                String syorisosikicd = khTtdkRireki.getSyorisosikicd();
                String hknsyukigou = kykSyouhn.getSyouhncd().substring(0, 2);

                int hhknnen = 0;
                if (kykSyouhn.getHhknnen() > 99) {
                    hhknnen = 99;
                }
                else {
                    hhknnen = kykSyouhn.getHhknnen();
                }

                int nenrei = setNenrei.exec(kykSyouhn.getKykymd(), kykSya.getKykseiymd());
                int kyknen = 0;
                if (nenrei > 99) {
                    kyknen = 99;
                }
                else {
                    kyknen = nenrei;
                }

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(kykSyouhn.getKykjyoutai().getValue(),
                    C_Kykjyoutai.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                String annaihuyouriyuukbn = "";
                if (kbnInfoBean.isHenkanFlg()) {
                    annaihuyouriyuukbn = kbnInfoBean.getKbnData();
                }
                else {
                    throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。区分名：案内不要理由区分　区分値："
                        + kykSyouhn.getKykjyoutai().getValue());
                }

                BizCurrency znnphr = BizCurrency.valueOf(0);
                BizCurrency sshkshrgk = BizCurrency.valueOf(0);
                BizCurrency mihrkmp = BizCurrency.valueOf(0);

                BizCurrency shrgk = khShrRireki.getYensyushrgkkei();

                BizCurrency sshkd = khShrRireki.getYenkansanhaitoukin().add(khShrRireki.getYensonotahaitoukin());

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai()) &&
                    C_Tuukasyu.JPY.eq(khShrRireki.getKyktuukasyu())) {

                    if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn()) &&
                        C_HtsiryosyuKbn.UKTRSHRTYOUSYO.eq(khShrRireki.getShrtysysyuruikbn())) {

                        znnphr = khShrRireki.getYenkansansonotaseisangk();
                    }

                    sshkshrgk = shrgk.add(znnphr).add(sshkd);
                }
                else {

                    sshkshrgk = khShrRireki.getYensynykngk();

                    if (C_HtsiryosyuKbn.UKTRSHRTYOUSYO.eq(khShrRireki.getShrtysysyuruikbn())) {

                        znnphr = sshkshrgk.subtract(shrgk.add(sshkd).add(khShrRireki.getYenkrkgk()));
                        mihrkmp = khShrRireki.getYenkrkgk();
                    }
                    else if (C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(khShrRireki.getShrtysysyuruikbn())) {

                        znnphr = sshkshrgk.subtract(shrgk.add(sshkd));
                    }
                }

                String mfadrsiyouhyouji = "";
                String shrtysytsinyno = "";
                String shrtysyadr1kj = "";
                String shrtysyadr2kj = "";
                String shrtysyadr3kj = "";
                String uktnmkj = "";

                if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn())) {
                    if (!BizUtil.isBlank(khShrRireki.getKyksyaszkadr1kj())) {
                        mfadrsiyouhyouji = "0";
                        shrtysytsinyno = khShrRireki.getKyksyaszkyno();
                        shrtysyadr1kj = khShrRireki.getKyksyaszkadr1kj();
                        shrtysyadr2kj = khShrRireki.getKyksyaszkadr2kj();
                        shrtysyadr3kj = khShrRireki.getKyksyaszkadr3kj();
                        uktnmkj = khShrRireki.getKyksyaszknmkj();

                    }
                    else {
                        mfadrsiyouhyouji = "1";
                        shrtysytsinyno = kykSya.getTsinyno();
                        shrtysyadr1kj = kykSya.getTsinadr1kj();
                        shrtysyadr2kj = kykSya.getTsinadr2kj();
                        shrtysyadr3kj = kykSya.getTsinadr3kj();
                        uktnmkj = kykSya.getKyknmkj();
                    }
                }
                else if (C_ShrsyoriKbn.GENGAKU.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn())) {
                    mfadrsiyouhyouji = "1";
                    shrtysytsinyno = kykSya.getTsinyno();
                    shrtysyadr1kj = kykSya.getTsinadr1kj();
                    shrtysyadr2kj = kykSya.getTsinadr2kj();
                    shrtysyadr3kj = kykSya.getTsinadr3kj();
                    uktnmkj = kykSya.getKyknmkj();

                }
                else if (C_ShrsyoriKbn.SBKAIJO.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.SBMENSEKI.eq(khShrRireki.getShrsyorikbn())) {
                    if (C_SoukinsakisiteiKbn.KYK.eq(khShrRireki.getSoukinsakisiteikbn())) {
                        mfadrsiyouhyouji = "1";
                        shrtysytsinyno = kykSya.getTsinyno();
                        shrtysyadr1kj = kykSya.getTsinadr1kj();
                        shrtysyadr2kj = kykSya.getTsinadr2kj();
                        shrtysyadr3kj = kykSya.getTsinadr3kj();
                        uktnmkj = kykSya.getKyknmkj();

                    }
                    else if (C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(khShrRireki.getSoukinsakisiteikbn())) {
                        mfadrsiyouhyouji = "0";
                        shrtysytsinyno = khShrRireki.getKyksyaszkyno();
                        shrtysyadr1kj = khShrRireki.getKyksyaszkadr1kj();
                        shrtysyadr2kj = khShrRireki.getKyksyaszkadr2kj();
                        shrtysyadr3kj = khShrRireki.getKyksyaszkadr3kj();
                        uktnmkj = khShrRireki.getKyksyaszknmkj();

                    }
                    else if (C_SoukinsakisiteiKbn.SONOTA.eq(khShrRireki.getSoukinsakisiteikbn())) {
                        mfadrsiyouhyouji = "0";
                        shrtysytsinyno = khShrRireki.getSoukinsakiyno();
                        shrtysyadr1kj = khShrRireki.getSoukinsakiadr1kj();
                        shrtysyadr2kj = khShrRireki.getSoukinsakiadr2kj();
                        shrtysyadr3kj = khShrRireki.getSoukinsakiadr3kj();
                        uktnmkj = khShrRireki.getSoukinsakinmkj();

                    }

                }

                String syoritaisyoukbn = "";
                if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn())) {
                    syoritaisyoukbn = "4";
                }
                else if (C_ShrsyoriKbn.GENGAKU.eq(khShrRireki.getShrsyorikbn())) {
                    syoritaisyoukbn = "43";
                }
                else if (C_ShrsyoriKbn.SBKAIJO.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.SBMENSEKI.eq(khShrRireki.getShrsyorikbn())) {
                    syoritaisyoukbn = "2";
                }

                String shrtysysyuruikbn = "";
                if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn())) {
                    if (C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(khShrRireki.getShrtysysyuruikbn())) {
                        shrtysysyuruikbn = "1";
                    }
                    else if (C_HtsiryosyuKbn.UKTRSHRTYOUSYO.eq(khShrRireki.getShrtysysyuruikbn())) {
                        shrtysysyuruikbn = "2";
                    }
                }
                else if (C_ShrsyoriKbn.GENGAKU.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn())) {
                    shrtysysyuruikbn = "1";
                }
                else if (C_ShrsyoriKbn.SBKAIJO.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.SBMENSEKI.eq(khShrRireki.getShrsyorikbn())) {
                    shrtysysyuruikbn = "2";
                }

                kykKihon = IT_KykKihonDetacher.detachKhTtdkTyuuitouched(kykKihon);
                IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

                List<C_TtdktyuuiKbn> ttdktyuuiKbnLst = new ArrayList<>();

                if (khTtdkTyuui != null) {
                    ttdktyuuiKbnLst.add(khTtdkTyuui.getTtdktyuuikbn1());
                    ttdktyuuiKbnLst.add(khTtdkTyuui.getTtdktyuuikbn2());
                    ttdktyuuiKbnLst.add(khTtdkTyuui.getTtdktyuuikbn3());
                    ttdktyuuiKbnLst.add(khTtdkTyuui.getTtdktyuuikbn4());
                    ttdktyuuiKbnLst.add(khTtdkTyuui.getTtdktyuuikbn5());
                }

                C_ShrhousiteiKbn shrhousiteikbn = null;

                if (C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn()) ||
                    (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn()) &&
                        C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(khShrRireki.getShrhousiteikbn()))) {
                    shrhousiteikbn = C_ShrhousiteiKbn.FB_YOKUJITU;
                }
                else  {
                    shrhousiteikbn = khShrRireki.getShrhousiteikbn();
                }

                String mnsaiannaihnskakbn = "";

                if (khTtdkTyuui == null) {
                    mnsaiannaihnskakbn = "00";
                }
                else  {
                    for (C_TtdktyuuiKbn ttdktyuuiKbn : ttdktyuuiKbnLst) {
                        if (ttdktyuuiKbnLst1.contains(ttdktyuuiKbn)) {
                            mnsaiannaihnskakbn = "02";
                            break;
                        }
                        mnsaiannaihnskakbn = "00";

                    }
                }

                String shrtysyhknsyukbn = syouhnZokusei.getShrtysyhknsyukbn().getValue();

                String tblsakuseihunodisp = "";

                if (C_ShrsyoriKbn.KAIYAKU.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.GENGAKU.eq(khShrRireki.getShrsyorikbn())) {
                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(khShrRireki.getShrhousiteikbn()) ||
                        C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        tblsakuseihunodisp = "1";
                    }
                    else {
                        if (khTtdkTyuui == null) {
                            tblsakuseihunodisp = "0";
                        } else {
                            for (C_TtdktyuuiKbn ttdktyuuiKbn : ttdktyuuiKbnLst) {
                                if (ttdktyuuiKbnLst2.contains(ttdktyuuiKbn)) {
                                    if (ttdktyuuiKbn.eq(C_TtdktyuuiKbn.ADRHUMEI) && "1".equals(mfadrsiyouhyouji)) {
                                        tblsakuseihunodisp = "1";
                                        break;
                                    } else if(ttdktyuuiKbn.eq(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI) ||ttdktyuuiKbn.eq(C_TtdktyuuiKbn.KAIGAITOKOU)) {
                                        tblsakuseihunodisp = "1";
                                        break;
                                    }
                                }
                                tblsakuseihunodisp = "0";
                            }
                        }
                    }
                }
                else if (C_ShrsyoriKbn.SBKAIJO.eq(khShrRireki.getShrsyorikbn()) ||
                    C_ShrsyoriKbn.SBMENSEKI.eq(khShrRireki.getShrsyorikbn())) {
                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(khShrRireki.getShrhousiteikbn()) ||
                        C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn()) ||
                        C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {
                        tblsakuseihunodisp = "1";

                    }
                    else {
                        if (khTtdkTyuui == null) {
                            tblsakuseihunodisp = "0";
                        } else {
                            for (C_TtdktyuuiKbn ttdktyuuiKbn : ttdktyuuiKbnLst) {
                                if (ttdktyuuiKbnLst3.contains(ttdktyuuiKbn)) {
                                    if (ttdktyuuiKbn.eq(C_TtdktyuuiKbn.ADRHUMEI) && "1".equals(mfadrsiyouhyouji)) {
                                        tblsakuseihunodisp = "1";
                                        break;

                                    } else if(ttdktyuuiKbn.eq(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE)
                                        || ttdktyuuiKbn.eq(C_TtdktyuuiKbn.MINJISAISEI)
                                        || ttdktyuuiKbn.eq(C_TtdktyuuiKbn.SYOUMETUJISEISAN)
                                        || ttdktyuuiKbn.eq(C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU)
                                        || ttdktyuuiKbn.eq(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI)
                                        || ttdktyuuiKbn.eq(C_TtdktyuuiKbn.KAIGAITOKOU)) {

                                        tblsakuseihunodisp = "1";
                                        break;
                                    }
                                }
                                tblsakuseihunodisp = "0";

                            }
                        }
                    }
                }
                else if (C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(khShrRireki.getShrsyorikbn())) {
                    if (khTtdkTyuui == null) {
                        tblsakuseihunodisp = "0";
                    } else {
                        for (C_TtdktyuuiKbn ttdktyuuiKbn : ttdktyuuiKbnLst) {
                            if (ttdktyuuiKbnLst2.contains(ttdktyuuiKbn)) {
                                if (ttdktyuuiKbn.eq(C_TtdktyuuiKbn.ADRHUMEI) && "1".equals(mfadrsiyouhyouji)) {
                                    tblsakuseihunodisp = "1";
                                    break;
                                }
                                else if(ttdktyuuiKbn.eq(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI) ||ttdktyuuiKbn.eq(C_TtdktyuuiKbn.KAIGAITOKOU)) {
                                    tblsakuseihunodisp = "1";
                                    break;
                                }
                            }
                            tblsakuseihunodisp = "0";
                        }
                    }
                }

                String shrkykhtykeihiyouhyj = "";
                String oldtsinyno = "";
                String oldtsinadr1kj = "";
                String oldtsinadr2kj = "";
                String oldtsinadr3kj = "";
                String oldkyknmkj = "";

                if (khShrRireki.getKykhnkkaisuu() > 0) {
                    shrkykhtykeihiyouhyj = "1";
                    List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiLst =
                        hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(
                            khShrRireki.getSyono(), C_Meigihnkjiyuu.KYK);

                    if (kykSyaHenkouRirekiLst.size() != 0) {

                        SortIT_KykSyaHenkouRireki kykSyaHenkouRirekiSort = SWAKInjector
                            .getInstance(SortIT_KykSyaHenkouRireki.class);

                        kykSyaHenkouRirekiLst = kykSyaHenkouRirekiSort
                            .OrderIT_KykSyaHenkouRirekiByHenkouSikibetuKeyDesc(kykSyaHenkouRirekiLst);
                        oldtsinyno = kykSyaHenkouRirekiLst.get(0).getOldtsinyno();
                        oldtsinadr1kj = kykSyaHenkouRirekiLst.get(0).getOldtsinadr1kj();
                        oldtsinadr2kj = kykSyaHenkouRirekiLst.get(0).getOldtsinadr2kj();
                        oldtsinadr3kj = kykSyaHenkouRirekiLst.get(0).getOldtsinadr3kj();
                        oldkyknmkj = kykSyaHenkouRirekiLst.get(0).getOldkyknmkj();

                    }

                }
                else if (khShrRireki.getKykhnkkaisuu() == 0) {
                    shrkykhtykeihiyouhyj = "0";
                }

                IT_KhTyousyo khTyousyo = new IT_KhTyousyo();

                khTyousyo.setSyono(khShrRireki.getSyono());
                khTyousyo.setTyouhyouymd(syoriYmd);
                khTyousyo.setShrtysyrenno(shrtysyrenno);
                khTyousyo.setKacd(kacd);
                khTyousyo.setTantocd(tantouCdKbn);
                khTyousyo.setHknsyukigou(hknsyukigou);
                khTyousyo.setHknkkn(kykSyouhn.getHknkkn());
                khTyousyo.setHrkkkn(kykSyouhn.getHrkkkn());
                khTyousyo.setHhknnen(hhknnen);
                khTyousyo.setKyknen(kyknen);
                khTyousyo.setKykymd(kykSyouhn.getKykymd());
                khTyousyo.setHhknsei(kykSyouhn.getHhknsei());
                khTyousyo.setHrkkaisuu(kykKihon.getHrkkaisuu());
                khTyousyo.setHrkkeiro(kykKihon.getHrkkeiro());
                khTyousyo.setAnnaihuyouriyuukbn(annaihuyouriyuukbn);
                khTyousyo.setHrkp(BizCurrency.valueOf(0));
                khTyousyo.setKouryokuhasseiymd(khShrRireki.getKouryokuhasseiymd());
                khTyousyo.setMfadrsiyouhyouji(mfadrsiyouhyouji);
                khTyousyo.setKihrpdmiseibidisp("0");
                khTyousyo.setKihrpseibiyoudisp("0");
                khTyousyo.setShrgk(shrgk);
                khTyousyo.setWarimsishrgkbizc(BizCurrency.valueOf(0));
                khTyousyo.setZnnphrbizc(znnphr);
                khTyousyo.setTtkekstkganribizc(BizCurrency.valueOf(0));
                khTyousyo.setSshkdbizc(sshkd);
                khTyousyo.setSshkshrgk(sshkshrgk);
                khTyousyo.setMihrkmpbizc(mihrkmp);
                khTyousyo.setShrymd(khShrRireki.getShrymd());
                khTyousyo.setSyorisosikicd(syorisosikicd);
                khTyousyo.setSyoritaisyoukbn(syoritaisyoukbn);
                khTyousyo.setShrtysytsinyno(shrtysytsinyno);
                khTyousyo.setShrtysyadr1kj(shrtysyadr1kj);
                khTyousyo.setShrtysyadr2kj(shrtysyadr2kj);
                khTyousyo.setShrtysyadr3kj(shrtysyadr3kj);
                khTyousyo.setKyknmkj(kykSya.getKyknmkj());
                khTyousyo.setHhknnmkj(hhknSya.getHhknnmkj());
                khTyousyo.setUktnmkj(uktnmkj);
                khTyousyo.setKjdaihyouuktnm("");
                khTyousyo.setShrtienrsk(BizCurrency.valueOf(0));
                khTyousyo.setKihons(BizCurrency.valueOf(0));
                khTyousyo.setShrtysysyuruicd(shrtysysyuruikbn);
                khTyousyo.setTeknjikihrpseibidisp("0");
                khTyousyo.setKihrkmp(khShrRireki.getYenhtykeihi());
                khTyousyo.setOnlinecentercutkbn("1");
                khTyousyo.setShrhousiteikbn(shrhousiteikbn);
                khTyousyo.setHtykeihihnsyukbn("2");
                khTyousyo.setSyuseijtshrdbizc(BizCurrency.valueOf(0));
                khTyousyo.setTouduketorihouhoukbn("0");
                khTyousyo.setNenkinkkn(0);
                khTyousyo.setBankcd("0000");
                khTyousyo.setBanknmkn("");
                khTyousyo.setSitencd("000");
                khTyousyo.setSitennmkn("");
                khTyousyo.setYokinkbn(C_YokinKbn.BLNK);
                khTyousyo.setYokinknmkn("");
                khTyousyo.setKouzano("000000000000");
                khTyousyo.setKzmeiginmkn("");
                khTyousyo.setSakuseiymd(syoriYmd);
                khTyousyo.setKykmnmeigibangou(khShrRireki.getKykmnmeigibangou());
                khTyousyo.setUktmnmeigibangou(khShrRireki.getUktmnmeigibangou());
                khTyousyo.setJigyoukykmndantaicd("");
                khTyousyo.setMnsaiannaihnskakbn(mnsaiannaihnskakbn);
                khTyousyo.setHuho2kykdisp("1");
                khTyousyo.setShrtysyhknsyukbn(C_ShrtysyhknsyuKbn.valueOf(shrtysyhknsyukbn));
                khTyousyo.setShrtysykurikosidisp(khShrRireki.getShrtysykurikosiyouhi().getValue());
                khTyousyo.setTsinyno(kykSya.getTsinyno());
                khTyousyo.setTsinadr1kj(kykSya.getTsinadr1kj());
                khTyousyo.setTsinadr2kj(kykSya.getTsinadr2kj());
                khTyousyo.setTsinadr3kj(kykSya.getTsinadr3kj());
                khTyousyo.setSynyhsjykykndisp("0");
                khTyousyo.setTblsakuseihunodisp(tblsakuseihunodisp);
                khTyousyo.setDaihyouktkbn("0");
                khTyousyo.setGyoumuKousinKinou(kinouId);
                khTyousyo.setGyoumuKousinsyaId(userId);
                khTyousyo.setGyoumuKousinTime(sysDateTime);
                khTyousyo.setOldtsinyno(oldtsinyno);
                khTyousyo.setOldtsinadr1kj(oldtsinadr1kj);
                khTyousyo.setOldtsinadr2kj(oldtsinadr2kj);
                khTyousyo.setOldtsinadr3kj(oldtsinadr3kj);
                khTyousyo.setOldkyknmkj(oldkyknmkj);
                khTyousyo.setKykhnkkaisuu(khShrRireki.getKykhnkkaisuu());
                khTyousyo.setShrkykhtykeihiyouhyj(shrkykhtykeihiyouhyj);
                khTyousyo.setShrkykhtykeihi(khShrRireki.getYenshrkykhtykeihi());

                BizPropertyInitializer.initialize(khTyousyo);

                khTyousyoIns.add(khTyousyo);

                count++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));

        }

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
