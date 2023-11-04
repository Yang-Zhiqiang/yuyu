package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.def.db.entity.IT_KhDshrTuki;

/**
 * Ｄ支払統計データ作成{@link SrDshrTukiDataSks}のモッククラスです<br />
 */
public class SrDshrTukiDataSksMockForHozen extends SrDshrTukiDataSks {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public IT_KhDshrTuki execKhKsnAri(EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean,
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean) {
        if (caller == EditKaiyakuTblUpdateTest_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)){
                IT_KhDshrTuki khDshrTuki = new IT_KhDshrTuki();
                khDshrTuki.setCalckijyunymd(BizDate.valueOf("20181001"));
                khDshrTuki.setHenkousikibetukey("1001");
                khDshrTuki.setSiharaid(BizCurrency.valueOf(15000));
                khDshrTuki.setDshrtoukeisikibetukey("1111");
                khDshrTuki.setRenno(1);
                khDshrTuki.setSyono("17806000013");

                return khDshrTuki;
            }
        }
        return super.execKhKsnAri(editDshrTukiTanKoumokuBean, editDshrTukiDKoumokuBean);
    }
}