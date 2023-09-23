package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 （支払）未収Ｐ・未経過Ｐ計算
 */
public class ShrKeisanMsyMkeiP {

    private BizCurrency misyuP;

    private int misyuPJyutouKaisuuY;

    private int misyuPJyutouKaisuuM;

    private BizDateYM misyuPJyutouYM;

    private MisyuuPBean[] misyuuPBeans;

    private BizCurrency mikeikaP;

    private int mikeikaPJyutouKaisuuY;

    private int mikeikaPJyutouKaisuuM;

    private BizDateYM mikeikaPJyutouYM;

    private MiKeikaPBean[] miKeikaPBeans;

    @Inject
    private SetOutoubi setOutoubi;

    @Inject
    private KeisanMsyMkeiP keisanMsyMkeiP;

    @Inject
    private IkkatuPGkCal ikkatuPGkCal;

    @Inject
    private MiKeikaPBean miKeikaPBean;

    @Inject
    private HozenDomManager hozenDomManager;

    public ShrKeisanMsyMkeiP() {
        super();
    }

    public BizCurrency getMisyuP() {
        return misyuP;
    }

    public int getMisyuPJyutouKaisuuY() {
        return misyuPJyutouKaisuuY;
    }

    public int getMisyuPJyutouKaisuuM() {
        return misyuPJyutouKaisuuM;
    }

    public BizDateYM getMisyuPJyutouYM() {
        return misyuPJyutouYM;
    }

    public MisyuuPBean[] getMisyuuPBeans() {
        return misyuuPBeans;
    }

    public BizCurrency getMikeikaP() {
        return mikeikaP;
    }

    public int getMikeikaPJyutouKaisuuY() {
        return mikeikaPJyutouKaisuuY;
    }

    public int getMikeikaPJyutouKaisuuM() {
        return mikeikaPJyutouKaisuuM;
    }

    public BizDateYM getMikeikaPJyutouYM() {
        return mikeikaPJyutouYM;
    }

    public MiKeikaPBean[] getMiKeikaPBeans() {
        return miKeikaPBeans;
    }

    public void exec(String pSyoNo, BizDate pKeisanYmd, BizDate pDenYmd) {

        misyuP = BizCurrency.valueOf(0);
        misyuPJyutouKaisuuY = 0;
        misyuPJyutouKaisuuM = 0;
        misyuPJyutouYM = null;
        misyuuPBeans = null;
        mikeikaP = BizCurrency.valueOf(0);
        mikeikaPJyutouKaisuuY = 0;
        mikeikaPJyutouKaisuuM = 0;
        mikeikaPJyutouYM = null;
        miKeikaPBeans = null;

        /*
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);
        if (ansyuKihon == null) {
            throw new CommonBizAppException("システム整合性エラーです。証券番号=" + pSyoNo);
        }
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        if (kykKihon == null) {
            throw new CommonBizAppException("システム整合性エラーです。証券番号=" + pSyoNo);
        }
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (kykSyouhnLst.size() == 0) {
            throw new CommonBizAppException("システム整合性エラーです。証券番号=" + pSyoNo);
        }

        C_Hrkkaisuu hrkkaisuu = kykKihon.getHrkkaisuu();
        BizDate kykYmd = kykSyouhnLst.get(0).getKykymd();
        BizDate haraimanYmd = kykSyouhnLst.get(0).getHaraimanymd();
        BizDateYM jkipJytYM = ansyuKihon.getJkipjytym();
        BizCurrency hrkP = kykKihon.getHrkp();

        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            return;
        }

        BizDate kykOutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
            kykYmd,
            hrkkaisuu,
            pKeisanYmd);

        BizDateYM kykOutouYM = kykOutouYmd.getBizDateYM();
        BizDateYM haraimanYM = haraimanYmd.getBizDateYM();

        BizDateYM hrkKiYM;
        if (kykOutouYM.compareTo(haraimanYM) <= 0) {
            hrkKiYM = kykOutouYM;
        }
        else {
            hrkKiYM = haraimanYM;
        }

        if (BizDateUtil.compareYm(jkipJytYM, hrkKiYM) == BizDateUtil.COMPARE_LESSER) {
            keisanMsyMkeiP.exec(pSyoNo,
                pKeisanYmd,
                C_MisyuptsKbn.TS);

            misyuuPBeans = keisanMsyMkeiP.getMisyuuPBeans();
            misyuP = keisanMsyMkeiP.getMisyuP();
            misyuPJyutouKaisuuY = keisanMsyMkeiP.getMisyuPJyutouKaisuuY();
            misyuPJyutouKaisuuM = keisanMsyMkeiP.getMisyuPJyutouKaisuuM();
            misyuPJyutouYM = keisanMsyMkeiP.getMisyuPJyutouYM();

            BizDate keisanbiTykgoOutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                kykYmd,
                C_Hrkkaisuu.TUKI,
                pKeisanYmd);

            BizDateYM keisanbiTykgoOutouYM = keisanbiTykgoOutouYmd.getBizDateYM();

            BizDate keisanbiTykzenNextPJyutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN,
                kykYmd,
                hrkkaisuu,
                keisanbiTykgoOutouYmd);

            BizDateYM keisanbiTykzenNextPJyutouYM = keisanbiTykzenNextPJyutouYmd.getBizDateYM();

            if (keisanbiTykgoOutouYM.compareTo(hrkKiYM) < 0) {
                int keikaGetusuu = 0;
                List<MiKeikaPBean> miKeikaPBeanLst = new ArrayList<>();
                BizCurrency keikabunP = BizCurrency.valueOf(0);

                List<Object[]> kykSyouhnObjectLst = hozenDomManager.
                    getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(pSyoNo);

                keikaGetusuu = keisanbiTykgoOutouYM.subtractMonths(keisanbiTykzenNextPJyutouYM);

                for (Object[] kykSyouhn : kykSyouhnObjectLst) {
                    ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);
                    ikkatuPGkCal.setSyouhncd((String) kykSyouhn[1]);
                    ikkatuPGkCal.setSyouhnSdno((int) kykSyouhn[2]);
                    ikkatuPGkCal.setKatakbn((C_KataKbn) kykSyouhn[3]);
                    ikkatuPGkCal.setSyukyhkinKatakbn((C_SyukyhkinkataKbn) kykSyouhn[5]);
                    ikkatuPGkCal.setKhnkyhkgBairitukbn((C_KhnkyhkgbairituKbn) kykSyouhn[6]);
                    ikkatuPGkCal.set6daisktsykntuikakyhKatakbn((C_6daiLdKbn) kykSyouhn[7]);
                    ikkatuPGkCal.setPmnjTkkbn((C_PmnjtkKbn) kykSyouhn[8]);
                    ikkatuPGkCal.setKyhgndKatakbn((C_KyhgndkataKbn) kykSyouhn[4]);
                    ikkatuPGkCal.setHknkknSmnkbn((C_HknkknsmnKbn) kykSyouhn[9]);
                    ikkatuPGkCal.setHknkkn((int) kykSyouhn[10]);
                    ikkatuPGkCal.setHrkkknSmnkbn((C_HrkkknsmnKbn) kykSyouhn[11]);
                    ikkatuPGkCal.setHrkkkn((int) kykSyouhn[12]);
                    ikkatuPGkCal.setHhknNen((Integer) kykSyouhn[13]);
                    ikkatuPGkCal.setHhknSei((C_Hhknsei) kykSyouhn[14]);
                    ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                    ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                    ikkatuPGkCal.setS((BizCurrency) kykSyouhn[0]);
                    ikkatuPGkCal.setKeikatukisuu(keikaGetusuu);

                    ikkatuPGkCal.exec();

                    keikabunP = keikabunP.add(ikkatuPGkCal.getIkkatuP());
                }

                BizCurrency mikeikaPTemp = hrkP.subtract(keikabunP);

                int mikeikaM = Integer.parseInt(hrkkaisuu.getValue()) - keikaGetusuu;

                miKeikaPBean.setMiKeikaP(mikeikaPTemp);
                miKeikaPBean.setMkeiPNykDenYmd(pDenYmd);
                miKeikaPBean.setMkeiPHrkKaisuu(hrkkaisuu);
                miKeikaPBean.setMkeiPJytKaisuuY(0);
                miKeikaPBean.setMkeiPJytKaisuuM(mikeikaM);
                miKeikaPBean.setMkeiPJytYm(keisanbiTykzenNextPJyutouYM);

                miKeikaPBeanLst.add(miKeikaPBean);

                if (miKeikaPBeanLst.size() != 0) {
                    miKeikaPBeans = miKeikaPBeanLst.toArray(new MiKeikaPBean[miKeikaPBeanLst.size()]);
                    mikeikaP = mikeikaPTemp;
                    mikeikaPJyutouKaisuuY = 0;
                    mikeikaPJyutouKaisuuM = mikeikaM;
                    mikeikaPJyutouYM = keisanbiTykgoOutouYM;
                }
            }
        }
        else {
            keisanMsyMkeiP.exec(pSyoNo,
                pKeisanYmd,
                C_MisyuptsKbn.MITS);

            miKeikaPBeans = keisanMsyMkeiP.getMiKeikaPBeans();
            mikeikaP = keisanMsyMkeiP.getMikeikaP();
            mikeikaPJyutouKaisuuY = keisanMsyMkeiP.getMikeikaPJyutouKaisuuY();
            mikeikaPJyutouKaisuuM = keisanMsyMkeiP.getMikeikaPJyutouKaisuuM();
            mikeikaPJyutouYM = keisanMsyMkeiP.getMikeikaPJyutouYM();
        }*/
    }
}