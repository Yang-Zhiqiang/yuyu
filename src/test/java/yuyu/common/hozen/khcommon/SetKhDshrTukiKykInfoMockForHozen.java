package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全D支払統計契約情報設定{@link SetKhDshrTukiKykInfo}のモッククラスです<br />
 */
public class SetKhDshrTukiKykInfoMockForHozen extends SetKhDshrTukiKykInfo {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public EditDshrTukiTanKoumokuBean exec(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam, BizDate pDenYmd,
        BizDate pSyoriYmd) {
        if (caller == EditKaiyakuTblUpdateTest_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)){
                EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = new EditDshrTukiTanKoumokuBean();

                editDshrTukiTanKoumokuBean.setRenno(1);
                editDshrTukiTanKoumokuBean.setSkno("001");
                editDshrTukiTanKoumokuBean.setSyono("17806000013");
                editDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20180129"));
                editDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("JUnit");
                editDshrTukiTanKoumokuBean.setGyoumuKousinKinou("EditKaiyakuTblUpdateTest_exec");

                return editDshrTukiTanKoumokuBean;
            }
        }
        return super.exec(pKykKihon, pKhozenCommonParam, pDenYmd, pSyoriYmd);
    }
}