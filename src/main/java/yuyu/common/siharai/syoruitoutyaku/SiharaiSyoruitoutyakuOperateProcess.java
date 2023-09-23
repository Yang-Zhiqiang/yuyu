package yuyu.common.siharai.syoruitoutyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.common.biz.koutei.BzSetImageRelation;
import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcess;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 保険金給付金支払 書類到着 保険金給付金支払書類到着時工程操作処理
 */
public class SiharaiSyoruitoutyakuOperateProcess extends SyoruitoutyakuOperateProcess {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSetImageRelation bzSetImageRelation;

    private String syoruitoutyakuNodeId;

    public SiharaiSyoruitoutyakuOperateProcess() {
        super();
    }

    @Override
    public boolean hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn pSyoruiCdKbn) {
        if (C_SyoruiCdKbn.HK_SB_HOKEN_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.eq(pSyoruiCdKbn)) {
            syoruitoutyakuNodeId = TeisuuSiharai.NODEID_SYORUITOUTYAKU;

            return true;
        }
        else if (C_SyoruiCdKbn.HK_SB_KAKUNINHKS.eq(pSyoruiCdKbn)) {
            syoruitoutyakuNodeId = TeisuuSiharai.NODEID_KAKUNINIRAITYUU;

            return true;
        }
        else if (C_SyoruiCdKbn.HK_SB_HUBITEISEI.eq(pSyoruiCdKbn)) {
            syoruitoutyakuNodeId = TeisuuSiharai.NODEID_HUBIKAITOUMATI;

            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public String getSyoruitoutyakuNodeId() {
        return syoruitoutyakuNodeId;
    }

    @Override
    public void doujiSeikyuu(String pImageId, String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn) {

        Boolean syoriFlg = false;
        if (syoriFlg) {

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(pKouteiKanriId);
            String skNo = gyoumuKouteiInfo.getSkno();

            List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySkno(skNo);
            List<String> doujiSkKouteikanriIdLst = new ArrayList<>();

            for (BT_GyoumuKouteiInfo gyoumuKouteiInfoTemp : gyoumuKouteiInfoLst) {
                String kouteikanriId = gyoumuKouteiInfoTemp.getKouteikanriid();
                String syuKouteikanriId = gyoumuKouteiInfoTemp.getSyukouteikanriid();

                if (!kouteikanriId.equals(pKouteiKanriId) && kouteikanriId.equals(syuKouteikanriId)) {
                    doujiSkKouteikanriIdLst.add(kouteikanriId);
                }
            }

            String[] doujiSkKouteikanriIds =
                doujiSkKouteikanriIdLst.toArray(new String[doujiSkKouteikanriIdLst.size()]);

            if (doujiSkKouteikanriIds.length > 0) {
                bzSetImageRelation.exec(pImageId, doujiSkKouteikanriIds);
            }
        }
    }
}