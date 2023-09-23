package yuyu.common.hozen.khcommon;

import java.util.List;
import javax.inject.Inject;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import org.slf4j.Logger;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.dba4hasseijikzieditshrtyousyotbl.HasseijikziEditShrtyousyotblDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 発生時課税支払調書TBL編集
 */
public class HasseijikziEditShrtyousyotbl {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private HasseijikziEditShrtyousyotblDao hasseijikziEditShrtyousyotblDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    public HasseijikziEditShrtyousyotbl() {
        super();
    }

    public IT_KhTyousyo exec(KhozenCommonParam pCommonParam, HasseijikziEditShrtyousyotblParam pTblParam) {

        logger.debug("▽ 発生時課税支払調書TBL編集 開始");

        IT_KhTyousyo tyousyo = new IT_KhTyousyo();

        IT_KykKihon kykKihon = null;
        if (C_KinouKbn.ONLINE.eq(kinou.getKinouKbn())) {

            kykKihon = pCommonParam.getKeiyakuKihonInfo(pTblParam.getSyono());
        }
        else {

            kykKihon = pCommonParam.getBatchKeiyakuKihon();
        }

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        if (syouhnZokusei == null) {

            throw new CommonBizAppException("商品属性マスタにデータが存在しません。" + "商品コード："
                + kykSyouhn.getSyouhncd() + "　商品世代番号：" + kykSyouhn.getSyouhnsdno());
        }

        Long shrtysyRenno = hasseijikziEditShrtyousyotblDao.getShrtysyrennoBySyonoTyouhyouymd(kykKihon.getSyono(),
            pTblParam.getSyoriymd());
        if (shrtysyRenno == null) {

            shrtysyRenno = 1L;
        } else {

            shrtysyRenno = shrtysyRenno + 1;
        }

        C_TantouCdKbn tantouCdKbn = C_TantouCdKbn.BLNK0;

        if (C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(pTblParam.getShrsyorikbn())) {

            tantouCdKbn = C_TantouCdKbn.KAIYAKU;
        }

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(tantouCdKbn);

        if (tantouCd == null) {

            throw new CommonBizAppException("担当コードマスタにデータが存在しません。" + "担当コード：" + tantouCdKbn);
        }

        String kaCd = tantouCd.getBusitucd();
        String hknSyuKigou = kykSyouhn.getSyouhncd().substring(0, 2);

        Integer hhknNen = kykSyouhn.getHhknnen();

        if (hhknNen > 99) {

            hhknNen = 99;
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int nenrei = setNenrei.exec(kykSyouhn.getKykymd(), kykSya.getKykseiymd());

        if (nenrei > 99) {

            nenrei = 99;
        }

        String annaiHuyouRiyuuKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(kykSyouhn.getKykjyoutai().getValue(), C_Kykjyoutai.class,
            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {

            annaiHuyouRiyuuKbn = kbnInfoBean.getKbnData();
        }
        else {

            throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。"
                + "区分名：案内不要理由区分　　区分値：" + kykSyouhn.getKykjyoutai());
        }

        String mfAdrSiyouHyouji = "";
        String shrtysyTsinyno = "";
        String shrtysyAdr1Kj = "";
        String shrtysyAdr2Kj = "";
        String shrtysyAdr3Kj = "";
        String uktNmKj = "";

        if (C_UmuKbn.NONE.eq(pTblParam.getMfadrsiyouhyouji())) {

            mfAdrSiyouHyouji = "0";
            shrtysyTsinyno = pTblParam.getShrtysytsinyno();
            shrtysyAdr1Kj = pTblParam.getShrtysyadr1kj();
            shrtysyAdr2Kj = pTblParam.getShrtysyadr2kj();
            shrtysyAdr3Kj = pTblParam.getShrtysyadr3kj();
            uktNmKj = pTblParam.getUktnmkj();
        }
        else {

            mfAdrSiyouHyouji = "1";
            shrtysyTsinyno = kykSya.getTsinyno();
            shrtysyAdr1Kj = kykSya.getTsinadr1kj();
            shrtysyAdr2Kj = kykSya.getTsinadr2kj();
            shrtysyAdr3Kj = kykSya.getTsinadr3kj();
            uktNmKj = kykSya.getKyknmkj();
        }

        String syoriTaisyouKbn = "";

        if (C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(pTblParam.getShrsyorikbn())) {

            syoriTaisyouKbn = "4";
        }

        BizCurrency znnPHr = null;
        BizCurrency sshkShrgk = null;

        BizCurrency sshkd = pTblParam.getYenhaitoukin().add(pTblParam.getYensonotahaitoukin());

        if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai()) || !C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

            sshkShrgk = pTblParam.getSynykngk();

            if (C_HtsiryosyuKbn.UKTRSHRTYOUSYO.eq(pTblParam.getHtsiryosyukbn())) {

                znnPHr = sshkShrgk.subtract(pTblParam.getShrgk().add(sshkd).add(pTblParam.getMihrkmp()));
            }
            else if (C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(pTblParam.getHtsiryosyukbn())) {

                znnPHr = sshkShrgk.subtract(pTblParam.getShrgk().add(sshkd));
            }
            else {

                znnPHr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
        }

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        String shrtysySyuruiKbn = "";

        if (C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(pTblParam.getHtsiryosyukbn())) {

            shrtysySyuruiKbn = "1";
        }
        else if (C_HtsiryosyuKbn.UKTRSHRTYOUSYO.eq(pTblParam.getHtsiryosyukbn())) {

            shrtysySyuruiKbn = "2";
        }

        String mnSaiannaiHnsKakbn = "00";

        if (khTtdkTyuui != null &&
            (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(khTtdkTyuui.getTtdktyuuikbn5()))) {

            mnSaiannaiHnsKakbn = "02";
        }

        C_ShrtysyhknsyuKbn shrtysyhknsyuKbn = syouhnZokusei.getShrtysyhknsyukbn();

        String tblSakuseiHunoDisp = "";

        if (C_ShrsyoriKbn.PMINYUUSYOUMETU.eq(pTblParam.getShrsyorikbn())) {

            if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pTblParam.getShrhousiteikbn())
                || C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pTblParam.getShrhousiteikbn())
                || (khTtdkTyuui != null &&
                ((C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn1()) && "1".equals(mfAdrSiyouHyouji)) ||
                    (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn2()) && "1".equals(mfAdrSiyouHyouji)) ||
                    (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn3()) && "1".equals(mfAdrSiyouHyouji)) ||
                    (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn4()) && "1".equals(mfAdrSiyouHyouji)) ||
                    (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn5()) && "1".equals(mfAdrSiyouHyouji)) ||
                    C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                    C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                    C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                    C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                    C_TtdktyuuiKbn.KAIGAITOKOU.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                    C_TtdktyuuiKbn.KAIGAITOKOU.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                    C_TtdktyuuiKbn.KAIGAITOKOU.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.KAIGAITOKOU.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                    C_TtdktyuuiKbn.KAIGAITOKOU.eq(khTtdkTyuui.getTtdktyuuikbn5())))) {

                tblSakuseiHunoDisp = "1";
            }
            else {

                tblSakuseiHunoDisp = "0";
            }
        }

        String oldTsinyno = "";
        String oldTsinAdr1Kj = "";
        String oldTsinAdr2Kj = "";
        String oldTsinAdr3Kj = "";
        String oldKykNmKj = "";
        String shrKykHtykeihiYouhyj = "0";

        if (pTblParam.getKykhnkkaisuu() > 0) {

            shrKykHtykeihiYouhyj = "1";

            List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiList = hozenDomManager
                .getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(kykKihon.getSyono(), C_Meigihnkjiyuu.KYK);

            if (kykSyaHenkouRirekiList.size() != 0) {

                oldTsinyno = kykSyaHenkouRirekiList.get(0).getOldtsinyno();
                oldTsinAdr1Kj = kykSyaHenkouRirekiList.get(0).getOldtsinadr1kj();
                oldTsinAdr2Kj = kykSyaHenkouRirekiList.get(0).getOldtsinadr2kj();
                oldTsinAdr3Kj = kykSyaHenkouRirekiList.get(0).getOldtsinadr3kj();
                oldKykNmKj = kykSyaHenkouRirekiList.get(0).getOldkyknmkj();
            }
        }

        tyousyo.setSyono(kykKihon.getSyono());
        tyousyo.setTyouhyouymd(pTblParam.getSyoriymd());
        tyousyo.setShrtysyrenno(shrtysyRenno);
        tyousyo.setKacd(kaCd);
        tyousyo.setTantocd(tantouCdKbn);
        tyousyo.setHknsyukigou(hknSyuKigou);
        tyousyo.setHknkkn(kykSyouhn.getHknkkn());
        tyousyo.setHrkkkn(kykSyouhn.getHrkkkn());
        tyousyo.setHhknnen(hhknNen);
        tyousyo.setKyknen(nenrei);
        tyousyo.setKykymd(kykSyouhn.getKykymd());
        tyousyo.setHhknsei(kykSyouhn.getHhknsei());
        tyousyo.setHrkkaisuu(kykKihon.getHrkkaisuu());
        tyousyo.setHrkkeiro(kykKihon.getHrkkeiro());
        tyousyo.setAnnaihuyouriyuukbn(annaiHuyouRiyuuKbn);
        tyousyo.setKouryokuhasseiymd(pTblParam.getKouryokuhasseiymd());
        tyousyo.setMfadrsiyouhyouji(mfAdrSiyouHyouji);
        tyousyo.setKihrpdmiseibidisp("0");
        tyousyo.setKihrpseibiyoudisp("0");
        tyousyo.setShrgk(pTblParam.getShrgk());
        tyousyo.setZnnphrbizc(znnPHr);
        tyousyo.setSshkdbizc(sshkd);
        tyousyo.setSshkshrgk(sshkShrgk);
        tyousyo.setMihrkmpbizc(pTblParam.getMihrkmp());
        tyousyo.setShrymd(pTblParam.getShrymd());
        tyousyo.setSyorisosikicd(pTblParam.getSyorisosikicd());
        tyousyo.setSyoritaisyoukbn(syoriTaisyouKbn);
        tyousyo.setShrtysytsinyno(shrtysyTsinyno);
        tyousyo.setShrtysyadr1kj(shrtysyAdr1Kj);
        tyousyo.setShrtysyadr2kj(shrtysyAdr2Kj);
        tyousyo.setShrtysyadr3kj(shrtysyAdr3Kj);
        tyousyo.setKyknmkj(kykSya.getKyknmkj());
        tyousyo.setHhknnmkj(hhknSya.getHhknnmkj());
        tyousyo.setUktnmkj(uktNmKj);
        tyousyo.setShrtysysyuruicd(shrtysySyuruiKbn);
        tyousyo.setTeknjikihrpseibidisp("0");
        tyousyo.setKihrkmp(pTblParam.getKihrkmp());
        tyousyo.setOnlinecentercutkbn("1");
        tyousyo.setShrhousiteikbn(pTblParam.getShrhousiteikbn());
        tyousyo.setHtykeihihnsyukbn("2");
        tyousyo.setTouduketorihouhoukbn("0");
        tyousyo.setBankcd("0000");
        tyousyo.setSitencd("000");
        tyousyo.setKouzano("000000000000");
        tyousyo.setSakuseiymd(pTblParam.getSyoriymd());
        tyousyo.setKykmnmeigibangou(pTblParam.getKykmnmeigibangou());
        tyousyo.setUktmnmeigibangou(pTblParam.getUktmnmeigibangou());
        tyousyo.setMnsaiannaihnskakbn(mnSaiannaiHnsKakbn);
        tyousyo.setHuho2kykdisp("1");
        tyousyo.setShrtysyhknsyukbn(shrtysyhknsyuKbn);
        tyousyo.setShrtysykurikosidisp("0");
        tyousyo.setTsinyno(kykSya.getTsinyno());
        tyousyo.setTsinadr1kj(kykSya.getTsinadr1kj());
        tyousyo.setTsinadr2kj(kykSya.getTsinadr2kj());
        tyousyo.setTsinadr3kj(kykSya.getTsinadr3kj());
        tyousyo.setSynyhsjykykndisp("0");
        tyousyo.setTblsakuseihunodisp(tblSakuseiHunoDisp);
        tyousyo.setDaihyouktkbn("0");
        tyousyo.setGyoumuKousinKinou(pCommonParam.getFunctionId());
        tyousyo.setGyoumuKousinsyaId(pCommonParam.getUserID());
        tyousyo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        tyousyo.setOldtsinyno(oldTsinyno);
        tyousyo.setOldtsinadr1kj(oldTsinAdr1Kj);
        tyousyo.setOldtsinadr2kj(oldTsinAdr2Kj);
        tyousyo.setOldtsinadr3kj(oldTsinAdr3Kj);
        tyousyo.setOldkyknmkj(oldKykNmKj);
        tyousyo.setKykhnkkaisuu(pTblParam.getKykhnkkaisuu());
        tyousyo.setShrkykhtykeihiyouhyj(shrKykHtykeihiYouhyj);
        tyousyo.setShrkykhtykeihi(pTblParam.getShrkykhtykeihi());

        BizPropertyInitializer.initialize(tyousyo);

        logger.debug("△ 発生時課税支払調書TBL編集 終了");

        return tyousyo;
    }
}
