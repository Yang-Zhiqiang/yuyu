package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;


/**
 * {@link EditKhHenkouRirekiTbl}のモッククラスです。<br />
 */
public class EditKhHenkouRirekiTblMock extends EditKhHenkouRirekiTbl {

    public static Class<?> caller = null;

    @Inject
    private KhozenCommonParam KhozenCommonParam;

    @Override
    public List<IT_KhHenkouRireki> exec(IT_KykKihon pKykKihon, IT_BAK_KykKihon pBakKykKihon, IT_AnsyuKihon pAnsyuKihon,
        IT_BAK_AnsyuKihon pBakAnsyuKihon, IT_NyuukinKakusyouData pNyuukinKakusyouData, String pHenkouSikibetuKeyRenno) {

        List<IT_KhHenkouRireki> khHenkouRirekiLst = new ArrayList<>();
        IT_KhHenkouRireki khHenkouRireki = new IT_KhHenkouRireki();

        if (caller == EditTtdkRirekiTblTest_exec.class && KhozenCommonParam.getFunctionId() == "KhozenCommonParam") {
            return khHenkouRirekiLst;
        } else if (caller == EditTtdkRirekiTblTest_exec.class && KhozenCommonParam.getFunctionId() == "EditTtdkRirekiTbl") {
            khHenkouRireki.setBfrnaiyou("1");
            khHenkouRirekiLst.add(khHenkouRireki);
            return khHenkouRirekiLst;
        } else if (caller == EditTtdkRirekiTblTest_exec.class && KhozenCommonParam.getFunctionId() == "asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfg") {
            return khHenkouRirekiLst;
        }

        return super.exec(pKykKihon, pBakKykKihon, pAnsyuKihon, pBakAnsyuKihon, pNyuukinKakusyouData,
            pHenkouSikibetuKeyRenno);
    }
}
