package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm;
import yuyu.common.biz.bzcommon.GetBunsyoNoTest_execGetYakkanBunsyoNo;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenTest_execChkDairitenKengen;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.CheckNenreiHaniTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseKytKmTest_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditCsvHubiMikaiTest_exec_2;
import yuyu.common.sinkeiyaku.skcommon.EditCsvHubiMikaiTest_exec_3;
import yuyu.common.sinkeiyaku.skcommon.EditDairitenAtesakiTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHubiTyouhyouTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfTrksseikyuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenInfoTest_exec;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * {@link BzGetAgInfo}のモッククラスです。<br />
 */
public class BzGetAgInfoMock extends BzGetAgInfo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public int count = 0;

    @Override
    public List<BzGetAgInfoBean> exec(String pDrtenCd) {

        if (caller == EditPdfTrksseikyuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfTrksseikyuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setChannelCd(C_Channelcd.SINKIN);
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfTrksseikyuTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setChannelCd(C_Channelcd.TIGIN);
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setChannelCd(C_Channelcd.TIGIN);
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

            BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
            bzGetAgInfoBean3.setChannelCd(C_Channelcd.TIGIN);
            bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean3.setKanjiDairitenNm("漢字代理店名");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

            BzGetAgInfoBean bzGetAgInfoBean4 = new BzGetAgInfoBean();
            bzGetAgInfoBean4.setChannelCd(C_Channelcd.TIGIN);
            bzGetAgInfoBean4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean4);
            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setOyadrtenCd("2001715");
            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.BLNK);
            bzGetAgInfoBean1.setOyadrtenCd("2001715");
            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行１");

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();

            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.BLNK);
            bzGetAgInfoBean2.setOyadrtenCd("2001715");
            bzGetAgInfoBean2.setDrtenJimCd("0123");
            bzGetAgInfoBean2.setKanjiDairitenNm("万事屋銀行２");

            BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();

            bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean3.setOyadrtenCd("2001715");
            bzGetAgInfoBean3.setDrtenJimCd("0123");
            bzGetAgInfoBean3.setKanjiDairitenNm("万事屋銀行３");

            BzGetAgInfoBean bzGetAgInfoBean4 = new BzGetAgInfoBean();

            bzGetAgInfoBean4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean4.setOyadrtenCd("2001715");
            bzGetAgInfoBean4.setDrtenJimCd("0123");
            bzGetAgInfoBean4.setKanjiDairitenNm("万事屋銀行４");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean4);

            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setOyadrtenCd("2001715");
            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setOyadrtenCd("2001715");
            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }

        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setOyadrtenCd("2001715");

            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN15.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();


            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);

            bzGetAgInfoBean1.setOyadrtenCd(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank());

            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfHubiTyouhyouTest_exec.class && TESTPATTERN16.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();


            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);


            bzGetAgInfoBean1.setOyadrtenCd(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank());

            bzGetAgInfoBean1.setDrtenJimCd("0123");
            bzGetAgInfoBean1.setKanjiDairitenNm("万事屋銀行");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setOyadrtenCd("9001717");
            bzGetAgInfoBean.setDrtenCd("3001715");
            bzGetAgInfoBean.setDrtKanrisosikiCd1("4000015");
            bzGetAgInfoBean.setDrtenCd("");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setOyadrtenCd("2001716");
            bzGetAgInfoBean.setDrtenCd("3001716");
            bzGetAgInfoBean.setDrtKanrisosikiCd1("4000016");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setOyadrtenCd("");
            bzGetAgInfoBean.setDrtenCd("3001715");
            bzGetAgInfoBean.setDrtKanrisosikiCd1("4000015");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setOyadrtenCd("9001717");
            bzGetAgInfoBean.setDrtenCd("3001715");
            bzGetAgInfoBean.setDrtKanrisosikiCd1("4000015");
            bzGetAgInfoBean.setKydBosyuuDairitenHyouji(C_KydBosyuuDairitenHyouji.BLNK);

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean1.setOyadrtenCd("9001717");
            bzGetAgInfoBean1.setDrtenCd("3001719");
            bzGetAgInfoBean1.setDrtKanrisosikiCd1("4000019");
            bzGetAgInfoBean1.setKydBosyuuDairitenHyouji(C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
            bzGetAgInfoBean2.setKydBosyuuDairitenHyouji(C_KydBosyuuDairitenHyouji.KYOUDOUBOSYUU);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean1.setOyadrtenCd("9001717");
            bzGetAgInfoBean1.setDrtenCd("3001719");
            bzGetAgInfoBean1.setDrtKanrisosikiCd1("4000019");
            bzGetAgInfoBean1.setChannelCd(C_Channelcd.MIZUHO);
            bzGetAgInfoBean1.setKydBosyuuDairitenHyouji(null);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean.setOyadrtenCd("2001721");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setOyadrtenCd("2101079");
            bzGetAgInfoBean.setDrtenCd("3001715");
            bzGetAgInfoBean.setDaiBosyuuCd("123450");
            bzGetAgInfoBean.setDrtKanrisosikiCd1("4000015");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean1.setOyadrtenCd("9001717");
            bzGetAgInfoBean1.setDrtenCd("3001719");
            bzGetAgInfoBean1.setDrtKanrisosikiCd1("4000019");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN16.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean1.setOyadrtenCd("2001719");
            bzGetAgInfoBean1.setDrtenCd("3001719");
            bzGetAgInfoBean1.setDrtKanrisosikiCd1("4000019");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditCsvHubiMikaiTest_exec_2.class) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean.setKanjiDairitenNm("代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean.setKanjiDairitenNm("代理店名２");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean1.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINKOUKEIDAI);
                bzGetAgInfoBean1.setKinyuuSitenCd("1001");
                bzGetAgInfoBean1.setDrtenJimCd("2001");
                bzGetAgInfoBean1.setKanjiDairitenNm("代理店名３");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean2.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean2.setKinyuuSitenCd("1002");
                bzGetAgInfoBean2.setDrtenJimCd("2002");
                bzGetAgInfoBean2.setKanjiDairitenNm("代理店名４");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                return bzGetAgInfoBeanLst;
            }
        }
        else if (caller == EditCsvHubiMikaiTest_exec_3.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if ("2010009".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean1.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINKOUKEIDAI);
                bzGetAgInfoBean1.setKinyuuSitenCd("1001");
                bzGetAgInfoBean1.setDrtenJimCd("2001");
                bzGetAgInfoBean1.setKanjiDairitenNm("代理店名５");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            }
            if ("2010010".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean1.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINKOUKEIDAI);
                bzGetAgInfoBean1.setKinyuuSitenCd("1002");
                bzGetAgInfoBean1.setDrtenJimCd("2002");
                bzGetAgInfoBean1.setKanjiDairitenNm("代理店名６");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean2.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean2.setKinyuuSitenCd("1003");
                bzGetAgInfoBean2.setDrtenJimCd("2003");
                bzGetAgInfoBean2.setKanjiDairitenNm("代理店名７");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean3.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean3.setKinyuuSitenCd("1004");
                bzGetAgInfoBean3.setDrtenJimCd("2004");
                bzGetAgInfoBean3.setKanjiDairitenNm("代理店名８");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            }
            if ("2010011".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean1.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean1.setKinyuuSitenCd("1005");
                bzGetAgInfoBean1.setDrtenJimCd("2005");
                bzGetAgInfoBean1.setKanjiDairitenNm("代理店名９代理店名９代理店名９");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean2.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINKOUKEIDAI);
                bzGetAgInfoBean2.setKinyuuSitenCd("1006");
                bzGetAgInfoBean2.setDrtenJimCd("2006");
                bzGetAgInfoBean2.setKanjiDairitenNm("代理店名１０");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean3.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
                bzGetAgInfoBean3.setKinyuuSitenCd("1007");
                bzGetAgInfoBean3.setDrtenJimCd("2007");
                bzGetAgInfoBean3.setKanjiDairitenNm("代理店名１１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            }
            return bzGetAgInfoBeanLst;
        }
        else if (caller == CheckTuusanTest_exec.class && SYORIPTN.equals(TESTPATTERN1)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean1.setTkrtkKinyuuknHyouji(C_TkrtkKinyuuknHyouji.TOKUREITIIKI);
            bzGetAgInfoBean1.setKydsskKinyuuknHyouji(C_KydsskKinyuuknHyouji.BLNK);

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            return bzGetAgInfoBeanLst;

        }
        else if (caller == CheckTuusanTest_exec.class && SYORIPTN.equals(TESTPATTERN2)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();

            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
            bzGetAgInfoBean1.setTkrtkKinyuuknHyouji(C_TkrtkKinyuuknHyouji.TOKUREITIIKI);
            bzGetAgInfoBean1.setKydsskKinyuuknHyouji(C_KydsskKinyuuknHyouji.BLNK);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();

            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean2.setTkrtkKinyuuknHyouji(C_TkrtkKinyuuknHyouji.BLNK);
            bzGetAgInfoBean2.setKydsskKinyuuknHyouji(C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI);

            BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();

            bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean3.setTkrtkKinyuuknHyouji(C_TkrtkKinyuuknHyouji.BLNK);
            bzGetAgInfoBean3.setKydsskKinyuuknHyouji(C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI);

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            return bzGetAgInfoBeanLst;

        }
        else if (caller == CheckTuusanTest_exec.class && SYORIPTN.equals(TESTPATTERN3)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;

        }
        else if (caller == CheckTblMosSyouhinTest_exec.class) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setChannelCd(C_Channelcd.SMBC);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.SMBC);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean2.setChannelCd(C_Channelcd.SMTB);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean3.setChannelCd(C_Channelcd.BLNK);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setOyadrtenCd("2001718");
                bzGetAgInfoBean.setDrtenCd("3001718");
                bzGetAgInfoBean.setDrtKanrisosikiCd1("4000018");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }
            else {
            }
            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbSeihoWebMosSyoukaiTest_execPostForm.class) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                bzGetAgInfoBean.setDrtenCd("1300071");
                bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                bzGetAgInfoBean.setDrtenCd("1300071");
                bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean1.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                bzGetAgInfoBean1.setDrtenCd("1300071");
                bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if ("1501003".equals(pDrtenCd)) {
                    BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                    bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                    bzGetAgInfoBean1.setDrtenCd("1300071");
                    bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                    BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                    bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean2.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                }

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                if ("1501004".equals(pDrtenCd)) {
                    BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                    bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                    BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                    bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                    bzGetAgInfoBean2.setKanjiDairitenNm("横浜代理店");
                    bzGetAgInfoBean2.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                    BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                    bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                    bzGetAgInfoBean3.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                    bzGetAgInfoBean3.setDrtenCd("1300071");
                    bzGetAgInfoBean3.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                }

                else {
                    BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                    bzGetAgInfoBean.setKanjiDairitenNm("大手庁代理店");
                    bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                }

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean2.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean3.setDrtenCd("1300071");
                bzGetAgInfoBean3.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                BzGetAgInfoBean bzGetAgInfoBean4 = new BzGetAgInfoBean();
                bzGetAgInfoBean4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean4.setKanjiDairitenNm("東京代理店");
                bzGetAgInfoBean4.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean4);

                return bzGetAgInfoBeanLst;
            }

            else if (TESTPATTERN6.equals(SYORIPTN)) {

                if ("1502003".equals(pDrtenCd)) {
                    BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                    bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                    bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                }

                return bzGetAgInfoBeanLst;

            }

            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                bzGetAgInfoBean.setDrtenCd("1300071");
                bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;

            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店");
                bzGetAgInfoBean.setDrtenCd("1300072");
                bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.BLNK);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;

            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店巣");
                bzGetAgInfoBean.setDrtenCd("1300071");
                bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBean1.setKanjiDairitenNm("巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店巣");
                bzGetAgInfoBean1.setDrtenCd("1300071");
                bzGetAgInfoBean1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                return bzGetAgInfoBeanLst;
            }
            return bzGetAgInfoBeanLst;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setKanjiDairitenNm("大手庁代理店");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            return bzGetAgInfoBeanLst;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            if (pDrtenCd.equals("D002")) {

                return bzGetAgInfoBeanLst;
            }
            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean.setKanjiDairitenNm("大手庁代理店");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            return bzGetAgInfoBeanLst;
        }

        if ((caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN))
            || caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN4.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
            bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
            bzGetAgInfoBea1.setKanjiDairitenNm("大手庁代理店");
            bzGetAgInfoBea1.setDrtenCd("D007");
            bzGetAgInfoBea1.setKinyuuCd("K007");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

            BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
            bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBea2.setKanjiDairitenNm("大手庁代理店");
            bzGetAgInfoBea2.setDrtenCd("D007");
            bzGetAgInfoBea2.setKinyuuCd("K007");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);

            BzGetAgInfoBean bzGetAgInfoBea3 = new BzGetAgInfoBean();
            bzGetAgInfoBea3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBea3.setKanjiDairitenNm("大手庁代理店");
            bzGetAgInfoBea3.setDrtenCd("D007");
            bzGetAgInfoBea3.setKinyuuCd("K007");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBea3);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            return bzGetAgInfoBeanLst;

        }

        if (caller == CheckNenreiHaniTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
                bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBea2.setChannelCd(C_Channelcd.SMBC);
                bzGetAgInfoBea2.setOyadrtenCd("1100001");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);

                BzGetAgInfoBean bzGetAgInfoBea3 = new BzGetAgInfoBean();
                bzGetAgInfoBea3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBea3.setChannelCd(C_Channelcd.TIGIN);
                bzGetAgInfoBea3.setOyadrtenCd("1100002");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBea3);

                return bzGetAgInfoBeanLst;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                return bzGetAgInfoBeanLst;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                return bzGetAgInfoBeanLst;
            }
        }

        if (caller == HbSeihoWebHanteiKengenTest_execChkDairitenKengen.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBea1.setDrtenCd("1300073");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
                bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBea2.setDrtenCd("1300072");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);

                BzGetAgInfoBean bzGetAgInfoBea3 = new BzGetAgInfoBean();
                bzGetAgInfoBea3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBea3.setDrtenCd("1300073");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea3);

                BzGetAgInfoBean bzGetAgInfoBea4 = new BzGetAgInfoBean();
                bzGetAgInfoBea4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBea4.setDrtenCd("1300072");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea4);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBea1.setDrtenCd("1300074");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
                bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBea2.setDrtenCd("1300071");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);

                BzGetAgInfoBean bzGetAgInfoBea3 = new BzGetAgInfoBean();
                bzGetAgInfoBea3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBea3.setDrtenCd("1300074");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea3);

                BzGetAgInfoBean bzGetAgInfoBea4 = new BzGetAgInfoBean();
                bzGetAgInfoBea4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBea4.setDrtenCd("1300071");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea4);

                return bzGetAgInfoBeanLst;
            }
        }
        else if (caller == GetDairitenInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBea1.setKanjiDairitenNm("取扱代理店名");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
                bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBea2.setKanjiDairitenNm("親代理店名");
                bzGetAgInfoBea2.setOyadrtenCd("1100003");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);

                return bzGetAgInfoBeanLst;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBea1.setKanjiDairitenNm("親代理店名");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                return bzGetAgInfoBeanLst;
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {

                if (pDrtenCd.equals("1100006")) {

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                    BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                    bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBea1.setKanjiDairitenNm("取扱代理店名０");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);

                    BzGetAgInfoBean bzGetAgInfoBea2 = new BzGetAgInfoBean();
                    bzGetAgInfoBea2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                    bzGetAgInfoBea2.setKanjiDairitenNm("取扱代理店名１");
                    bzGetAgInfoBea2.setOyadrtenCd("1100008");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBea2);
                    return bzGetAgInfoBeanLst;
                }
                else if (pDrtenCd.equals("1100007")) {
                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                    BzGetAgInfoBean bzGetAgInfoBea1 = new BzGetAgInfoBean();
                    bzGetAgInfoBea1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBea1.setKanjiDairitenNm("取扱代理店名１");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBea1);
                    return bzGetAgInfoBeanLst;
                }

            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                return bzGetAgInfoBeanLst;
            }
        }
        else if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setKanjiHoujinSyougou("漢字法人商号");
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.BLNK);
                bzGetAgInfoBean1.setOyadrtenCd("5100000");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                if ("5110001".equals(pDrtenCd)) {
                    bzGetAgInfoBean2.setKanjiHoujinSyougou("漢字法人商号１２３４５６７８９０１２３４５");
                    bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
                    bzGetAgInfoBean2.setOyadrtenCd("5200000");
                }
                else if ("5110002".equals(pDrtenCd)) {
                    bzGetAgInfoBean2.setKanjiHoujinSyougou("漢字法人商号１２３４５６７８９０１２３");
                    bzGetAgInfoBean2.setChannelCd(C_Channelcd.SHOP);
                    bzGetAgInfoBean2.setOyadrtenCd("5300000");
                }
                else if ("5110003".equals(pDrtenCd)) {
                    bzGetAgInfoBean2.setKanjiHoujinSyougou("漢字法人商号１２３４５６７８９０１２３４");
                    bzGetAgInfoBean2.setChannelCd(C_Channelcd.SINKIN);
                    bzGetAgInfoBean2.setOyadrtenCd("5300000");
                }
                else if ("5110004".equals(pDrtenCd)) {
                    bzGetAgInfoBean2.setKanjiHoujinSyougou("漢字法人商号１２３４５６７８９０１２３４５");
                    bzGetAgInfoBean2.setChannelCd(C_Channelcd.SMBC);
                    bzGetAgInfoBean2.setOyadrtenCd("5400000");
                }
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                return bzGetAgInfoBeanLst;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return null;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (!"A401501".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }
            else {
                bzGetAgInfoBeanLst = null;
            }

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (!"A401501".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (!"A401501".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0001");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0002");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0003");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0004");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            } else {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0001");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0002");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0003");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0004");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if (!"A401501".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0001");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0002");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0003");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0004");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            } else {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0001");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0002");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("B0003");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0004");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            }

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean.setOyadrtenCd("A0001");
            bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean.setOyadrtenCd("A0002");
            bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名２");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean.setOyadrtenCd("A0003");
            bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名３");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            bzGetAgInfoBean = new BzGetAgInfoBean();
            bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean.setOyadrtenCd("A0004");
            bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名４");

            bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

            return bzGetAgInfoBeanLst;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            if ("A10010".equals(pDrtenCd)) {
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0001");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0002");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名２");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0003");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名３");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("A0004");
                bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名４");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
            } else {

                if ("3801501".equals(pDrtenCd) || "3801502".equals(pDrtenCd)) {
                    BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0001");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0002");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名２");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0003");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名３");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0004");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名４");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                } else {

                    BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0001");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名１");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("B0002");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名２");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("A0003");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名３");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                    bzGetAgInfoBean = new BzGetAgInfoBean();
                    bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                    bzGetAgInfoBean.setOyadrtenCd("A0004");
                    bzGetAgInfoBean.setKanjiDairitenNm("取扱代理店名４");

                    bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                }
            }
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setDrtenJimCd("0001");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            return bzGetAgInfoBeanLst;
        }
        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

            BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
            bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean3.setDrtenJimCd("");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

            BzGetAgInfoBean bzGetAgInfoBean4 = new BzGetAgInfoBean();
            bzGetAgInfoBean4.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean4);

            return bzGetAgInfoBeanLst;
        }
        else  if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("9900001");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                return bzGetAgInfoBeanLst;
            }
        }
        else  if (EditDairitenAtesakiTest_exec.class == caller && TESTPATTERN17.equals(SYORIPTN)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
            bzGetAgInfoBean1.setKanjiDairitenNm("代理店００");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
            bzGetAgInfoBean2.setKanjiDairitenNm("代理店０１");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

            return bzGetAgInfoBeanLst;
        }
        else  if (EditDairitenAtesakiTest_exec.class == caller && TESTPATTERN18.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            return bzGetAgInfoBeanLst;
        }

        else if(EditKykNaiyouOsiraseKytKmTest_editInfo.class == caller && TESTPATTERN1.equals(SYORIPTN)) {

            if (count == 0) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setOyadrtenCd("002");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setOyadrtenCd("002");
                bzGetAgInfoBean3.setKanjiHoujinSyougou("漢字法人商号");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                count++;

                return bzGetAgInfoBeanLst;
            }
            else {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("003");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setOyadrtenCd("003");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setOyadrtenCd("003");
                bzGetAgInfoBean3.setKanjiHoujinSyougou("漢字法人商号２");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                return bzGetAgInfoBeanLst;
            }
        }
        else if(EditKykNaiyouOsiraseKytKmTest_editInfo.class == caller && TESTPATTERN2.equals(SYORIPTN)) {

            if (count == 0) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setOyadrtenCd("002");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setOyadrtenCd("002");
                bzGetAgInfoBean3.setKanjiHoujinSyougou("漢字法人商号");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                count++;

                return bzGetAgInfoBeanLst;
            }
            else {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setOyadrtenCd("002");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setOyadrtenCd("002");
                bzGetAgInfoBean3.setKanjiHoujinSyougou("漢字法人商号");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

                return bzGetAgInfoBeanLst;
            }
        }

        else if(EditKykNaiyouOsiraseKytKmTest_editInfo.class == caller && TESTPATTERN3.equals(SYORIPTN)) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
            BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
            bzGetAgInfoBean1.setOyadrtenCd("001");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

            BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
            bzGetAgInfoBean2.setOyadrtenCd("002");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

            BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
            bzGetAgInfoBean3.setOyadrtenCd("002");
            bzGetAgInfoBean3.setKanjiHoujinSyougou("漢字法人商号");
            bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);

            return bzGetAgInfoBeanLst;
        }

        else if(GetBunsyoNoTest_execGetYakkanBunsyoNo.class == caller) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            if(TESTPATTERN1.equals(SYORIPTN)) {

            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.BLNK);
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            }
            else if(TESTPATTERN3.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.SMBC);
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.BLNK);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);

                BzGetAgInfoBean bzGetAgInfoBean2 = new BzGetAgInfoBean();
                bzGetAgInfoBean2.setOyadrtenCd("002");
                bzGetAgInfoBean2.setChannelCd(C_Channelcd.MIZUHO);
                bzGetAgInfoBean2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean2);

                BzGetAgInfoBean bzGetAgInfoBean3 = new BzGetAgInfoBean();
                bzGetAgInfoBean3.setOyadrtenCd("003");
                bzGetAgInfoBean3.setChannelCd(C_Channelcd.SMTB);
                bzGetAgInfoBean3.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean3);
            }
            else {
                bzGetAgInfoBeanLst = null;
            }

            return bzGetAgInfoBeanLst;
        }

        return super.exec(pDrtenCd);
    }
}