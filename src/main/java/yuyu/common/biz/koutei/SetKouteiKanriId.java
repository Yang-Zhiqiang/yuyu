package yuyu.common.biz.koutei;

import javax.annotation.Nullable;
import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 業務共通 工程 工程管理ＩＤ設定
 */
public class SetKouteiKanriId {

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    @Nullable
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    public SetKouteiKanriId() {
        super();
    }

    public String exec(SetKouteiKanriIdInBean pSetKouteiKanriIdInBean) {

        String kouteiKanriId = uniqueKeyGenerator.generateUniqueKey();

        String oyaKouteiKanriId = "";
        String oyaKouteiJimutetuzukiCd = "";

        if (BizUtil.isBlank(pSetKouteiKanriIdInBean.getOyaKouteiKanriId())
            || BizUtil.isBlank(pSetKouteiKanriIdInBean.getOyaKouteiJimutetuzukiCd())) {

            oyaKouteiKanriId = kouteiKanriId;
            oyaKouteiJimutetuzukiCd = pSetKouteiKanriIdInBean.getJimutetuzukiCd();
        }
        else {
            oyaKouteiKanriId = pSetKouteiKanriIdInBean.getOyaKouteiKanriId();
            oyaKouteiJimutetuzukiCd = pSetKouteiKanriIdInBean.getOyaKouteiJimutetuzukiCd();
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = new BT_GyoumuKouteiInfo();

        gyoumuKouteiInfo.setKouteikanriid(kouteiKanriId);
        gyoumuKouteiInfo.setSubSystemId(pSetKouteiKanriIdInBean.getSubSystemId());
        gyoumuKouteiInfo.setJimutetuzukicd(pSetKouteiKanriIdInBean.getJimutetuzukiCd());
        gyoumuKouteiInfo.setMosno(pSetKouteiKanriIdInBean.getMosNo());
        gyoumuKouteiInfo.setSyono(pSetKouteiKanriIdInBean.getSyoNo());
        gyoumuKouteiInfo.setSkno(pSetKouteiKanriIdInBean.getSkNo());
        gyoumuKouteiInfo.setNksysyno(pSetKouteiKanriIdInBean.getNkSysyNo());
        gyoumuKouteiInfo.setSyukouteikanriid(oyaKouteiKanriId);
        gyoumuKouteiInfo.setSyukouteijimutetuzukicd(oyaKouteiJimutetuzukiCd);
        if (kinou == null) {
            gyoumuKouteiInfo.setGyoumuKousinKinou(YuyuBizConfig.getInstance().getProvideKinouId());
        }
        else {
            gyoumuKouteiInfo.setGyoumuKousinKinou(kinou.getKinouId());
        }
        gyoumuKouteiInfo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        gyoumuKouteiInfo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(gyoumuKouteiInfo);

        bizDomManager.insert(gyoumuKouteiInfo);

        return kouteiKanriId;
    }
}
