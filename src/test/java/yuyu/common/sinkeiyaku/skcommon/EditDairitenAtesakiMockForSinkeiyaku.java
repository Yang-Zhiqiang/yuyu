package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * {@link EditDairitenAtesaki}のモッククラスです。<br />
 */
public class EditDairitenAtesakiMockForSinkeiyaku extends EditDairitenAtesaki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzDairitenAtesakiBean exec(EditDairitenAtesakiBean pEditDairitenAtesakiBean) {

        if (caller == EditPdfTrksseikyuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);

                bzDairitenAtesakiBean.setIrDrtenhassouymd("12月29日");

                bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");

                bzDairitenAtesakiBean.setIrDrtentsinyno("1234567");

                bzDairitenAtesakiBean.setIrDrtenshsadrkj("代理店送付先住所（漢字）");

                bzDairitenAtesakiBean.setIrDrtentsinatenakj("代理店通信先宛名（漢字）");

                bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");

                bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");

                bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");

                bzDairitenAtesakiBean.setIrDrtenjimcd("代理店事務所コード");

                bzDairitenAtesakiBean.setIrToiawaseyno("問合せ先郵便番号");

                bzDairitenAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");

                bzDairitenAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");

                bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

                bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");

                bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者名");

                bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");

                bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

                bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

                bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMTB);

                return bzDairitenAtesakiBean;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);

                bzDairitenAtesakiBean.setIrDrtenhassouymd("12月29日");

                bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");

                bzDairitenAtesakiBean.setIrDrtentsinyno("1234567");

                bzDairitenAtesakiBean.setIrDrtenshsadrkj("代理店送付先住所（漢字）");

                bzDairitenAtesakiBean.setIrDrtentsinatenakj("代理店通信先宛名（漢字）");

                bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");

                bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");

                bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");

                bzDairitenAtesakiBean.setIrDrtenjimcd("代理店事務所コード");

                bzDairitenAtesakiBean.setIrToiawaseyno("7654321");

                bzDairitenAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");

                bzDairitenAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");

                bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

                bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");

                bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者名");

                bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");

                bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

                bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

                bzDairitenAtesakiBean.setIrToiawaseteluktkkanou1("20180103");

                bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

                return bzDairitenAtesakiBean;
            }
        }

        if (caller == EditPdfYoteirirtuTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                BzDairitenAtesakiBean bzDairitenAtesakiBean = new BzDairitenAtesakiBean();

                bzDairitenAtesakiBean.setIrDrtenhassouymd("12月29日");
                bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
                bzDairitenAtesakiBean.setIrDrtentsinyno("1234567");
                bzDairitenAtesakiBean.setIrDrtenshsadrkj("代理店送付先住所（漢字）");
                bzDairitenAtesakiBean.setIrDrtentsinatenakj("代理店通信先宛名（漢字）");
                bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
                bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
                bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
                bzDairitenAtesakiBean.setIrDrtenjimcd("代理店事務所コード");
                bzDairitenAtesakiBean.setIrToiawaseyno("7654321");
                bzDairitenAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
                bzDairitenAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
                bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
                bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
                bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者名");
                bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
                bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
                bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
                bzDairitenAtesakiBean.setIrToiawaseteluktkkanou1("20180103");
                bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);
                return bzDairitenAtesakiBean;

            }
        }

        return super.exec(pEditDairitenAtesakiBean);
    }
}