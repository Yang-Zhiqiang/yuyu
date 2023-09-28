package yuyu.common.biz.syoruiitiran;


import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.GetSyoruiJohoItiranListResultBean;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.SyoruiJohoItiranBean;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.SyoruiResultConstants;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.SyoruiUtility;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HtysyoruiumuKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;

import com.google.common.collect.Lists;

/**
 * 業務共通 書類情報一覧 書類情報一覧設定
 */
public class SetSyoruiInfoItiran {

    public void exec(SetSyoruiInfoItiranExecUiBeanParam pUiBean) {

        String kouteiKanriId = "";
        if (BizUtil.isBlank(pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId())) {
            kouteiKanriId = pUiBean.getBzWorkflowInfo().getKouteiKanriId();
        }
        else {
            kouteiKanriId = pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId();
        }

        GetSyoruiJohoItiranListResultBean getSyoruiJohoItiranListResultBean = SyoruiUtility.getSyoruiJohoItiran(new String[] {kouteiKanriId});

        if (!SyoruiResultConstants.RESULT_OK.equals(getSyoruiJohoItiranListResultBean.getSyorikekkaStatus())) {
            throw new  CommonBizAppException("書類情報一覧設定処理が正常終了しませんでした。");
        }

        List<SyoruiInfoItiranDataSourceBeanCommonParam> syoruiInfoListDataSourceBeanLst = Lists.newArrayList();

        List<SyoruiJohoItiranBean> syoruiJohoItiranBeanLst= getSyoruiJohoItiranListResultBean.getSyoruiJohoItiranBeanList();

        String[] imageids = new String [syoruiJohoItiranBeanLst.size()];

        for (int index = 0; index < syoruiJohoItiranBeanLst.size(); index++) {

            SyoruiInfoItiranDataSourceBeanCommonParam syoruiInfoListDataSourceBean = pUiBean.createSyoruiInfoItiranDataSourceBean();

            SyoruiJohoItiranBean syoruiJohoItiranBean = syoruiJohoItiranBeanLst.get(index);

            if (BizUtil.isBlank(syoruiJohoItiranBean.getSyoruiTtykYmdTime())) {
                syoruiInfoListDataSourceBean.setSyoruittykymdtime("");
            }
            else {
                syoruiInfoListDataSourceBean.setSyoruittykymdtime(DefaultDateFormatter.formatYMDHMZeroFill(
                    syoruiJohoItiranBean.getSyoruiTtykYmdTime().substring(0, 12)));
            }

            if (BizUtil.isBlank(syoruiJohoItiranBean.getHituyouSyorui())) {
                syoruiInfoListDataSourceBean.setHtysyoruiumukbn(C_HtysyoruiumuKbn.BLNK);
            }
            else {
                syoruiInfoListDataSourceBean.setHtysyoruiumukbn(C_HtysyoruiumuKbn.MARU);
            }

            syoruiInfoListDataSourceBean.setSyoruinm(syoruiJohoItiranBean.getSyoruiNnm());

            if (BizUtil.isBlank(syoruiJohoItiranBean.getHyoujiLink())) {
                syoruiInfoListDataSourceBean.setHyoujilink("");
            }
            else {
                String hyoujiLink = MessageUtil.getMessage(MessageId.IBW0002);
                syoruiInfoListDataSourceBean.setHyoujilink(hyoujiLink);
            }

            syoruiInfoListDataSourceBean.setHyoujilinkflg(syoruiJohoItiranBean.getHyoujiLinkFlg());

            syoruiInfoListDataSourceBean.setImageid(syoruiJohoItiranBean.getImageId());

            syoruiInfoListDataSourceBean.setTorikomiSyoruiCd(syoruiJohoItiranBean.getTorikomiSyoruiCd());

            syoruiInfoListDataSourceBeanLst.add(syoruiInfoListDataSourceBean);

            if ("1".equals(syoruiJohoItiranBean.getHyoujiLink()) &&
                "1".equals(syoruiJohoItiranBean.getHyoujiLinkFlg())) {

                imageids[index] = syoruiJohoItiranBean.getImageId();
            }
            else {

                imageids[index] = null;
            }
        }

        pUiBean.convertSyoruiInfoItiranForCommonParam(syoruiInfoListDataSourceBeanLst);

        pUiBean.setImageids(imageids);
    }

    public void exec(SetSyoruiInfoItiranExecUiBeanParam pUiBean,
        C_SyoruiInfoItiranHyoujiHouhouKbn pSyoruiInfoItiranHyoujiHouhouKbn) {

        if (pSyoruiInfoItiranHyoujiHouhouKbn == null) {
            throw new BizAppException(MessageId.EBF0010, "書類情報一覧表示方法区分");
        }

        String kouteiKanriId = "";
        if (BizUtil.isBlank(pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId())) {
            kouteiKanriId = pUiBean.getBzWorkflowInfo().getKouteiKanriId();
        }
        else {
            kouteiKanriId = pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId();
        }

        GetSyoruiJohoItiranListResultBean resultBean = null;

        if (C_SyoruiInfoItiranHyoujiHouhouKbn.JIMUTETUZUKI.eq(pSyoruiInfoItiranHyoujiHouhouKbn)) {
            resultBean = SyoruiUtility.getSyoruiJohoItiran(new String[] {kouteiKanriId});
        }
        else {
            resultBean = SyoruiUtility.getSyoruiJouhouItiranBetu(new String[] {kouteiKanriId});
        }

        if (!SyoruiResultConstants.RESULT_OK.equals(resultBean.getSyorikekkaStatus())) {
            throw new  CommonBizAppException("書類情報一覧設定処理が正常終了しませんでした。");
        }

        List<SyoruiInfoItiranDataSourceBeanCommonParam> syoruiInfoListDataSourceBeanLst = Lists.newArrayList();

        List<SyoruiJohoItiranBean> syoruiJohoItiranBeanLst= resultBean.getSyoruiJohoItiranBeanList();
        String[] imageids = new String [syoruiJohoItiranBeanLst.size()];

        for (int index = 0; index < syoruiJohoItiranBeanLst.size(); index++) {

            SyoruiInfoItiranDataSourceBeanCommonParam syoruiInfoBean = pUiBean.createSyoruiInfoItiranDataSourceBean();

            SyoruiJohoItiranBean syoruiJohoItiranBean = syoruiJohoItiranBeanLst.get(index);

            if (BizUtil.isBlank(syoruiJohoItiranBean.getSyoruiTtykYmdTime())) {
                syoruiInfoBean.setSyoruittykymdtime("");
            }
            else {
                syoruiInfoBean.setSyoruittykymdtime(DefaultDateFormatter.formatYMDHMZeroFill(
                    syoruiJohoItiranBean.getSyoruiTtykYmdTime().substring(0, 12)));
            }

            if (BizUtil.isBlank(syoruiJohoItiranBean.getHituyouSyorui())) {
                syoruiInfoBean.setHtysyoruiumukbn(C_HtysyoruiumuKbn.BLNK);
            }
            else {
                syoruiInfoBean.setHtysyoruiumukbn(C_HtysyoruiumuKbn.MARU);
            }

            syoruiInfoBean.setSyoruinm(syoruiJohoItiranBean.getSyoruiNnm());

            if (BizUtil.isBlank(syoruiJohoItiranBean.getHyoujiLink())) {
                syoruiInfoBean.setHyoujilink("");
            }
            else {
                String hyoujiLink = MessageUtil.getMessage(MessageId.IBW0002);
                syoruiInfoBean.setHyoujilink(hyoujiLink);
            }

            syoruiInfoBean.setHyoujilinkflg(syoruiJohoItiranBean.getHyoujiLinkFlg());

            syoruiInfoBean.setImageid(syoruiJohoItiranBean.getImageId());

            syoruiInfoBean.setTorikomiSyoruiCd(syoruiJohoItiranBean.getTorikomiSyoruiCd());

            syoruiInfoListDataSourceBeanLst.add(syoruiInfoBean);

            if ("1".equals(syoruiJohoItiranBean.getHyoujiLink()) &&
                "1".equals(syoruiJohoItiranBean.getHyoujiLinkFlg())) {

                imageids[index] = syoruiJohoItiranBean.getImageId();
            }
            else {

                imageids[index] = null;
            }
        }

        pUiBean.convertSyoruiInfoItiranForCommonParam(syoruiInfoListDataSourceBeanLst);

        pUiBean.setImageids(imageids);
    }

    public void init(SetSyoruiInfoItiranExecUiBeanParam pUiBean) {
        List<SyoruiInfoItiranDataSourceBeanCommonParam> beanLst = new ArrayList<>();
        pUiBean.convertSyoruiInfoItiranForCommonParam(beanLst);
    }
}
