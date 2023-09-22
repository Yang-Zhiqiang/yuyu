package yuyu.common.sinkeiyaku.syoruitoutyaku;

import iwf.callback.arriveimage.ToutyakuYoteiInfo;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.prereport.SyoruiToutyakuYoteiTouroku;
import yuyu.common.biz.syoruitoutyaku.GetSyoruitoutyakuInfo;
import yuyu.common.biz.syoruitoutyaku.ToutyakuInfoBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.workflowcore.scan.impl.ScanReceiveInfoBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_QrCodeTaikeiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 書類到着 新契約書類到着時管理情報取得処理
 */
public class SinkeiyakuGetSyoruitoutyakuInfo extends GetSyoruitoutyakuInfo {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SinkeiyakuGetSyoruitoutyakuInfo() {
        super();
    }

    @Override
    public ToutyakuYoteiInfo getToutyakuYoteiInfo(String pToutyakuKey) {

        ToutyakuInfoBean toutyakuInfoBean = SWAKInjector.getInstance(ToutyakuInfoBean.class);

        if (C_QrCodeTaikeiKbn.MOS.getValue().equals(pToutyakuKey.substring(0, 3))) {
        }
        else {
            return toutyakuInfoBean;
        }


        HT_MosMikakuteiSyorui mosMikakuteiSyorui = sinkeiyakuDomManager.getMosMikakuteiSyorui(pToutyakuKey);

        if (mosMikakuteiSyorui == null) {
            throw new BizLogicException(MessageId.EBA0023,"文書ID");
        }

        String mosNo = mosMikakuteiSyorui.getMosno();
        C_SyoruiCdKbn syoruiCdKbn = mosMikakuteiSyorui.getSyoruiCd();

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.
            getMosMikakuteiJyouhouKanri(mosNo);

        if (mosMikakuteiJyouhouKanri == null) {
            throw new CommonBizAppException("申込番号：" + mosNo + " " + "書類コード：" + syoruiCdKbn);
        }

        ScanReceiveInfoBean scanReceiveInfoBean = SWAKInjector.getInstance(ScanReceiveInfoBean.class);

        String scanUserId = scanReceiveInfoBean.getUserId();

        SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);
        SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);
        String jimuyouCd = "";

        if (!StringUtil.isNullOrBlank(scanUserId) && scanUserId.length() >= 3) {

            jimuyouCd = scanUserId.substring(scanUserId.length() - 3);
        }
        else {

            jimuyouCd = mosMikakuteiJyouhouKanri.getJimuyoucd();
        }

        skProcessCreateInBean.setSkeiJimuKbn(mosMikakuteiJyouhouKanri.getSkeijimukbn());
        skProcessCreateInBean.setMosUketukeKbn(mosMikakuteiJyouhouKanri.getMosuketukekbn());
        skProcessCreateInBean.setHknSyuruiNo(mosMikakuteiJyouhouKanri.getHknsyuruino());
        skProcessCreateInBean.setDairitenCd1(mosMikakuteiJyouhouKanri.getDairitencd1());
        skProcessCreateInBean.setDairitenCd2(mosMikakuteiJyouhouKanri.getDairitencd2());
        skProcessCreateInBean.setJimuyouCd(jimuyouCd);
        skProcessCreateInBean.setDoujimosUmu(mosMikakuteiJyouhouKanri.getDoujimosumu());
        skProcessCreateInBean.setMosYmd(null);
        skProcessCreateInBean.setJimuStartYmd(BizDate.getSysDateTimeMilli());
        skProcessCreateInBean.setSyoNo("");
        skProcessCreateInBean.setMosNo(mosNo);
        skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        String kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno(mosNo) ;

        for (HT_MosMikakuteiSyorui mosMikakuteiSyoru : mosMikakuteiSyoruiLst) {
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(mosMikakuteiSyoru.getSyoruiCd().getValue(),
                kouteiKanriId, mosMikakuteiSyoru.getDocumentid());
        }

        toutyakuInfoBean.setToutyakuKey(pToutyakuKey);
        toutyakuInfoBean.setAppKey(kouteiKanriId);
        toutyakuInfoBean.setSyoruiCdKbn(syoruiCdKbn);
        toutyakuInfoBean.setFlowId(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        toutyakuInfoBean.setSubSystemId(ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);

        return toutyakuInfoBean;
    }
}