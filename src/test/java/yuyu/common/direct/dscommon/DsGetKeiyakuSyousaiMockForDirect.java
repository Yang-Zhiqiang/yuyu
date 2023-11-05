package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai.DwGetHozenKeiyakuSyousaiTest_execPostForm;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousai;
import yuyu.common.direct.dscommon.DsKeiyakuSyousaiBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link DsGetKeiyakuSyousai}のモッククラスです<br />
 */
public class DsGetKeiyakuSyousaiMockForDirect extends DsGetKeiyakuSyousai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public DsKeiyakuSyousaiBean exec(String pSyoNo){

        DsKeiyakuSyousaiBean dsKeiyakuSyousaiBean = SWAKInjector.getInstance(DsKeiyakuSyousaiBean.class);

        if (caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                dsKeiyakuSyousaiBean.setSyono(pSyoNo);
                dsKeiyakuSyousaiBean.setSyouhnnm("");
                dsKeiyakuSyousaiBean.setHhknnmkn("");
                dsKeiyakuSyousaiBean.setHhknseiYmd(null);
                dsKeiyakuSyousaiBean.setKykymd(null);
                dsKeiyakuSyousaiBean.setTutakinUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setSbhsyUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setKghsyUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setIryhsyUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setRougohsyUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setSakuseiKijyunymd(null);
                dsKeiyakuSyousaiBean.setSksiKijyunymdKawaseRate(BizNumber.valueOf(0));
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdSakusei(null);
                dsKeiyakuSyousaiBean.setPtumitaTekinYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setPtumitaTekinKyktuuka(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
                dsKeiyakuSyousaiBean.setRstuukasyu(C_Tuukasyu.BLNK);
                dsKeiyakuSyousaiBean.setKaiyakuHrkeiYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setKaiyakuHrkeiKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKaiyakuhrsuiiUmukbn(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setAisyoumei("");
                dsKeiyakuSyousaiBean.setKyknmkn("");
                dsKeiyakuSyousaiBean.setKyknmkj("");
                dsKeiyakuSyousaiBean.setKykseiymd(null);
                dsKeiyakuSyousaiBean.setKyksei(C_Kyksei.BLNK);
                dsKeiyakuSyousaiBean.setSbuktnin(0);
                dsKeiyakuSyousaiBean.setUktmidasikbn1(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn1(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm1("");
                dsKeiyakuSyousaiBean.setUktmidasikbn2(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn2(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm2("");
                dsKeiyakuSyousaiBean.setUktmidasikbn3(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn3(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm3("");
                dsKeiyakuSyousaiBean.setUktmidasikbn4(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn4(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm4("");
                dsKeiyakuSyousaiBean.setUktmidasikbn5(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn5(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm5("");
                dsKeiyakuSyousaiBean.setUktmidasikbn6(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn6(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm6("");
                dsKeiyakuSyousaiBean.setUktmidasikbn7(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn7(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm7("");
                dsKeiyakuSyousaiBean.setUktmidasikbn8(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn8(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm8("");
                dsKeiyakuSyousaiBean.setUktmidasikbn9(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn9(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm9("");
                dsKeiyakuSyousaiBean.setUktmidasikbn10(C_UktsyuKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktkbn10(C_GkdtKoktuutiUktKbn.BLNK);
                dsKeiyakuSyousaiBean.setUktnm10("");
                dsKeiyakuSyousaiBean.setTrkKzknmkn1("");
                dsKeiyakuSyousaiBean.setTrkKzknmkn2("");
                dsKeiyakuSyousaiBean.setHknkknKaisiymd1(null);
                dsKeiyakuSyousaiBean.setHknkknManryouymd1(null);
                dsKeiyakuSyousaiBean.setDai1Hknkkn(0);
                dsKeiyakuSyousaiBean.setHknkknKaisiymd2(null);
                dsKeiyakuSyousaiBean.setHknkknManryouymd2(null);
                dsKeiyakuSyousaiBean.setDai2Hknkkn(0);
                dsKeiyakuSyousaiBean.setHknkknKaisiymd3(null);
                dsKeiyakuSyousaiBean.setHknkknManryouymd3(null);
                dsKeiyakuSyousaiBean.setStdrsktkyhkUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setYennykntkhkUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setGaikanykntkhkUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setTargettkhkUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setInitsbjiyenSitihsytkhukaUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setJyudkaigomeharaiTkhukaUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setZeiseitkkkTkykhukaUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setRyymdJitenkwsRate(BizNumber.valueOf(0));
                dsKeiyakuSyousaiBean.setRyymdJitenkwsRateStigi(BizNumber.valueOf(0));
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdRy(null);
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdRyStigi(null);
                dsKeiyakuSyousaiBean.setRsgakuYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setRsgakuStigi(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKijyunKingaku(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setItijibrpRsYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setItijibrpKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setItijibrpRsKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKihonHokenkngk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setMkhgkWari(0);
                dsKeiyakuSyousaiBean.setSibohknkngkYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setSibohknkngkKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setSgsbhknkngkYen(BizCurrency.valueOf(0));
                dsKeiyakuSyousaiBean.setSgsbhknkngkKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setSgsbhknkngkhyoujiUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setKjsmsaihakkouKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setKykmeigihnkKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setSyoukensaihkKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setStdrsktkytthkKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setTargettkhkKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setHokenkngkksnkekkaKbn(C_ErrorKbn.OK);
                dsKeiyakuSyousaiBean.setKykniyusyoukaiKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setTumitatekinitenKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setDskaiyakuKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setAdrhenkouKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setPhrkhouhenkouKahikbn(C_KahiKbn.HUKA);
                dsKeiyakuSyousaiBean.setDai3HknkknhyoujiUmu(C_UmuKbn.NONE);
                dsKeiyakuSyousaiBean.setYakkanBunsyoNo("");
                dsKeiyakuSyousaiBean.setKykdrtkykhukaUmu(C_UmuKbn.NONE);

                return dsKeiyakuSyousaiBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                dsKeiyakuSyousaiBean.setSyono(pSyoNo);
                dsKeiyakuSyousaiBean.setSyouhnnm("商品名");
                dsKeiyakuSyousaiBean.setHhknnmkn("カナカナ");
                dsKeiyakuSyousaiBean.setHhknseiYmd(BizDate.valueOf("19901102"));
                dsKeiyakuSyousaiBean.setKykymd(BizDate.valueOf("20161122"));
                dsKeiyakuSyousaiBean.setTutakinUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setSbhsyUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setKghsyUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setIryhsyUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setRougohsyUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setSakuseiKijyunymd(BizDate.valueOf("20161101"));
                dsKeiyakuSyousaiBean.setSksiKijyunymdKawaseRate(BizNumber.valueOf(100));
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdSakusei(BizDate.valueOf("20161102"));
                dsKeiyakuSyousaiBean.setPtumitaTekinYen(BizCurrency.valueOf(200));
                dsKeiyakuSyousaiBean.setPtumitaTekinKyktuuka(BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKyktuukasyu(C_Tuukasyu.JPY);
                dsKeiyakuSyousaiBean.setRstuukasyu(C_Tuukasyu.USD);
                dsKeiyakuSyousaiBean.setKaiyakuHrkeiYen(BizCurrency.valueOf(400));
                dsKeiyakuSyousaiBean.setKaiyakuHrkeiKyktuuka(BizCurrency.valueOf(5, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKaiyakuhrsuiiUmukbn(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setAisyoumei("愛称名");
                dsKeiyakuSyousaiBean.setKyknmkn("カナ");
                dsKeiyakuSyousaiBean.setKyknmkj("契約者名（漢字）");
                dsKeiyakuSyousaiBean.setKykseiymd(BizDate.valueOf("19801012"));
                dsKeiyakuSyousaiBean.setKyksei(C_Kyksei.FEMALE);
                dsKeiyakuSyousaiBean.setSbuktnin(4);
                dsKeiyakuSyousaiBean.setUktmidasikbn1(C_UktsyuKbn.SBUKT);
                dsKeiyakuSyousaiBean.setUktkbn1(C_GkdtKoktuutiUktKbn.NONE);
                dsKeiyakuSyousaiBean.setUktnm1("死亡受取人名１（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn2(C_UktsyuKbn.STDRSK);
                dsKeiyakuSyousaiBean.setUktkbn2(C_GkdtKoktuutiUktKbn.HHKN);
                dsKeiyakuSyousaiBean.setUktnm2("死亡受取人名２（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn3(C_UktsyuKbn.NKUKT);
                dsKeiyakuSyousaiBean.setUktkbn3(C_GkdtKoktuutiUktKbn.KYK);
                dsKeiyakuSyousaiBean.setUktnm3("死亡受取人名３（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn4(C_UktsyuKbn.KEIZKNKUKT);
                dsKeiyakuSyousaiBean.setUktkbn4(C_GkdtKoktuutiUktKbn.SOUZOKU);
                dsKeiyakuSyousaiBean.setUktnm4("死亡受取人名４（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn5(C_UktsyuKbn.SBHENKANUKT);
                dsKeiyakuSyousaiBean.setUktkbn5(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                dsKeiyakuSyousaiBean.setUktnm5("死亡受取人名５（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn6(C_UktsyuKbn.SONOTA);
                dsKeiyakuSyousaiBean.setUktkbn6(C_GkdtKoktuutiUktKbn.NASI);
                dsKeiyakuSyousaiBean.setUktnm6("死亡受取人名６（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn7(C_UktsyuKbn.SBUKT);
                dsKeiyakuSyousaiBean.setUktkbn7(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                dsKeiyakuSyousaiBean.setUktnm7("死亡受取人名７（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn8(C_UktsyuKbn.STDRSK);
                dsKeiyakuSyousaiBean.setUktkbn8(C_GkdtKoktuutiUktKbn.HHKN);
                dsKeiyakuSyousaiBean.setUktnm8("死亡受取人名８（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn9(C_UktsyuKbn.NKUKT);
                dsKeiyakuSyousaiBean.setUktkbn9(C_GkdtKoktuutiUktKbn.KYK);
                dsKeiyakuSyousaiBean.setUktnm9("死亡受取人名９（漢字）");
                dsKeiyakuSyousaiBean.setUktmidasikbn10(C_UktsyuKbn.KEIZKNKUKT);
                dsKeiyakuSyousaiBean.setUktkbn10(C_GkdtKoktuutiUktKbn.SOUZOKU);
                dsKeiyakuSyousaiBean.setUktnm10("死亡受取人名１０（漢字）");
                dsKeiyakuSyousaiBean.setTrkKzknmkn1("登録家族名１（カナ）");
                dsKeiyakuSyousaiBean.setTrkKzknmkn2("登録家族名２（カナ）");
                dsKeiyakuSyousaiBean.setHknkknKaisiymd1(BizDate.valueOf("20161201"));
                dsKeiyakuSyousaiBean.setHknkknManryouymd1(BizDate.valueOf("20250101"));
                dsKeiyakuSyousaiBean.setDai1Hknkkn(0);
                dsKeiyakuSyousaiBean.setHknkknKaisiymd2(BizDate.valueOf("20161202"));
                dsKeiyakuSyousaiBean.setHknkknManryouymd2(BizDate.valueOf("20260101"));
                dsKeiyakuSyousaiBean.setDai2Hknkkn(0);
                dsKeiyakuSyousaiBean.setHknkknKaisiymd3(BizDate.valueOf("20161203"));
                dsKeiyakuSyousaiBean.setHknkknManryouymd3(BizDate.valueOf("20270101"));
                dsKeiyakuSyousaiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setYennykntkhkUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setGaikanykntkhkUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setTargettkhkUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setInitsbjiyenSitihsytkhukaUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setJyudkaigomeharaiTkhukaUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setZeiseitkkkTkykhukaUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setRyymdJitenkwsRate(BizNumber.valueOf(600));
                dsKeiyakuSyousaiBean.setRyymdJitenkwsRateStigi(BizNumber.valueOf(100));
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdRy(BizDate.valueOf("20161101"));
                dsKeiyakuSyousaiBean.setKwsrateKijyunymdRyStigi(BizDate.valueOf("20161102"));
                dsKeiyakuSyousaiBean.setRsgakuYen(BizCurrency.valueOf(2000));
                dsKeiyakuSyousaiBean.setRsgakuStigi(BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKijyunKingaku(BizCurrency.valueOf(700));
                dsKeiyakuSyousaiBean.setItijibrpRsYen(BizCurrency.valueOf(750));
                dsKeiyakuSyousaiBean.setItijibrpKyktuuka(BizCurrency.valueOf(8, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setItijibrpRsKyktuuka(BizCurrency.valueOf(22, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setKihonHokenkngk(BizCurrency.valueOf(9, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setMkhgkWari(1000);
                dsKeiyakuSyousaiBean.setSibohknkngkYen(BizCurrency.valueOf(1100));
                dsKeiyakuSyousaiBean.setSibohknkngkKyktuuka(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setSgsbhknkngkYen(BizCurrency.valueOf(1300));
                dsKeiyakuSyousaiBean.setSgsbhknkngkKyktuuka(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR));
                dsKeiyakuSyousaiBean.setSgsbhknkngkhyoujiUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setKjsmsaihakkouKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setKykmeigihnkKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setSyoukensaihkKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setStdrsktkytthkKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setTargettkhkKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setHokenkngkksnkekkaKbn(C_ErrorKbn.ERROR);
                dsKeiyakuSyousaiBean.setKykniyusyoukaiKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setTumitatekinitenKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setDskaiyakuKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setAdrhenkouKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setPhrkhouhenkouKahikbn(C_KahiKbn.KA);
                dsKeiyakuSyousaiBean.setDai3HknkknhyoujiUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setKykdrtkykhukaUmu(C_UmuKbn.ARI);
                dsKeiyakuSyousaiBean.setYakkanBunsyoNo("1234567890");
                return dsKeiyakuSyousaiBean;
            }
        }
        return super.exec(pSyoNo);
    }
}
