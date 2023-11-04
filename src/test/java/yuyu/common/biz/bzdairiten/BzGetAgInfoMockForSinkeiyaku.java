package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm;
import yuyu.common.biz.bzcommon.GetBunsyoNoTest_execGetYakkanBunsyoNo;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;

/**
 * {@link BzGetAgInfo}のモッククラスです。<br />
 */
public class BzGetAgInfoMockForSinkeiyaku extends BzGetAgInfo{

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

    public static final String TESTPATTERN16 = "16";

    @Override
    public List<BzGetAgInfoBean> exec(String pDrtenCd) {

        if(GetBunsyoNoTest_execGetYakkanBunsyoNo.class == caller) {

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

            if(TESTPATTERN1.equals(SYORIPTN)) {

            }
            if(TESTPATTERN2.equals(SYORIPTN)) {

                BzGetAgInfoBean bzGetAgInfoBean1 = new BzGetAgInfoBean();
                bzGetAgInfoBean1.setOyadrtenCd("001");
                bzGetAgInfoBean1.setChannelCd(C_Channelcd.BLNK);
                bzGetAgInfoBean1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIOYA);
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean1);
            }
            if(TESTPATTERN3.equals(SYORIPTN)) {

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

            return bzGetAgInfoBeanLst;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                return bzGetAgInfoBeanLst;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setKanjiDairitenNm("大手庁代理店");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                if (pDrtenCd.equals("D002")) {

                    return bzGetAgInfoBeanLst;
                }
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setKanjiDairitenNm("大手庁代理店");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
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
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();

                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN4.equals(SYORIPTN)) {
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
        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm.class) {

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
        if (caller == CheckTblMosDairitenTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

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
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setOyadrtenCd("2001716");
                bzGetAgInfoBean.setDrtenCd("3001716");
                bzGetAgInfoBean.setDrtKanrisosikiCd1("4000016");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();
                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUKO);
                bzGetAgInfoBean.setOyadrtenCd("");
                bzGetAgInfoBean.setDrtenCd("3001715");
                bzGetAgInfoBean.setDrtKanrisosikiCd1("4000015");

                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);
                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

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
            else if (TESTPATTERN6.equals(SYORIPTN)) {

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
            else if (TESTPATTERN7.equals(SYORIPTN)) {

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
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                BzGetAgInfoBean bzGetAgInfoBean = new BzGetAgInfoBean();

                bzGetAgInfoBean.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
                bzGetAgInfoBean.setOyadrtenCd("2001721");
                bzGetAgInfoBeanLst.add(bzGetAgInfoBean);

                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = new ArrayList<>();
                return bzGetAgInfoBeanLst;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

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
            else if (TESTPATTERN11.equals(SYORIPTN)) {

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
            else if (TESTPATTERN16.equals(SYORIPTN)) {

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
        }
        if (caller == CheckTblMosSyouhinTest_exec.class) {
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
            return bzGetAgInfoBeanLst;
        }
        return super.exec(pDrtenCd);
    }

}
