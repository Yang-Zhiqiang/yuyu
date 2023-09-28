package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse.ImageInfoBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBT_HituyouSyoruiKanri;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.infr.report.PdfBuilder;
import yuyu.infr.report.PdfUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.lowagie.text.pdf.PdfReader;

/**
 * 【書類情報一覧】書類情報一覧ユーティリティクラスです。
 */
public class SyoruiUtility {

    static Logger logger =  LoggerFactory.getLogger(SyoruiUtility.class);

    public static GetSyoruiJohoItiranListResultBean getSyoruiJohoItiran(
            String[] pKouteikanriId) {

        BaseUserInfo baseUserInfo = SWAKInjector.getInstance(BaseUserInfo.class);

        GetSyoruiJohoItiranListResultBean Out = new GetSyoruiJohoItiranListResultBean();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfoList = bizDomManager.getAllTorikomiSyoruiHukaInfo();

        Map<String, Integer> sortNoMap = new HashMap<String, Integer>();

        for (BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo : torikomiSyoruiHukaInfoList) {
            sortNoMap.put(torikomiSyoruiHukaInfo.getSyoruiCd().getValue(), torikomiSyoruiHukaInfo.getSortNo());
        }

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfosDomList = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriids(pKouteikanriId);



        List<String> wkKouteikanriIds = new ArrayList<String>();
        for(int i=0;i<pKouteikanriId.length;i++ ){
            wkKouteikanriIds.add(pKouteikanriId[i]);
        }

        Map<String, String> jimMap = new HashMap<String, String>();


        boolean flg = true;
        for(int i=0; i<gyoumuKouteiInfosDomList.size(); i++ ){
            for(int j=0; j<pKouteikanriId.length; j++ ){
                flg = true;
                if(gyoumuKouteiInfosDomList.get(i).getKouteikanriid().equals(pKouteikanriId[j])){
                    jimMap.put(pKouteikanriId[j], gyoumuKouteiInfosDomList.get(i).getJimutetuzukicd());
                    flg = false;
                }
            }
            if(flg){
                wkKouteikanriIds.add(gyoumuKouteiInfosDomList.get(i).getKouteikanriid());
                jimMap.put(gyoumuKouteiInfosDomList.get(i).getKouteikanriid(), gyoumuKouteiInfosDomList.get(i).getJimutetuzukicd());
            }
        }


        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = new ArrayList<BT_HituyouSyoruiKanri>();
        for (int i=0; i<wkKouteikanriIds.size(); i++) {
            hituyouSyoruiKanriList.addAll(bizDomManager.getGyoumuKouteiInfo(wkKouteikanriIds.get(i)).getHituyouSyoruiKanris());
        }
        SortBT_HituyouSyoruiKanri sortBT_HituyouSyoruiKanri = SWAKInjector.getInstance(SortBT_HituyouSyoruiKanri.class);
        hituyouSyoruiKanriList = sortBT_HituyouSyoruiKanri.OrderBT_HituyouSyoruiKanriByPkAsc(hituyouSyoruiKanriList);

        List<BT_HituyouSyoruiKanri> WKTBL1 = Lists.newArrayList();

        for(int i=0;i<hituyouSyoruiKanriList.size();i++){

            BT_HituyouSyoruiKanri bt_HituyouSyoruiKanri = new BT_HituyouSyoruiKanri();
            bt_HituyouSyoruiKanri.setKouteikanriid(hituyouSyoruiKanriList.get(i).getKouteikanriid());
            bt_HituyouSyoruiKanri.setSyoruiCd(hituyouSyoruiKanriList.get(i).getSyoruiCd());

            WKTBL1.add(bt_HituyouSyoruiKanri);

        }

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        GetImagePropsInBean inBean = new GetImagePropsInBean();
        GetImagePropsOutBean outBean;
        List<ImagePropsBean> WKAPI = Lists.newArrayList();

        for (int i = 0; i < wkKouteikanriIds.size(); i++) {

            inBean = new GetImagePropsInBean();

            inBean.setAccountid(baseUserInfo.getUserId());
            inBean.setGyoumukey(wkKouteikanriIds.get(i));
            inBean.setFlowid(jimMap.get(wkKouteikanriIds.get(i)));

            outBean = iwfImageClient.execGetImageProps(inBean);

            Out.setSyousaiMessage(outBean.getSyousaimsg());
            Out.setSyousaiMessageCd(outBean.getSyousaimsgcd());

            if(!(outBean.getKekkastatus().equals(SyoruiResultConstants.RESULT_OK))){
                if (outBean.getSyousaimsgcd().equals("IWF9004")) {
                    continue;
                }
                Out.setSyorikekkaStatus(outBean.getKekkastatus());

                return Out;
            }


            ImagePropsBean bean;

            for( int j=0; j<outBean.getImagepropslist().size(); j++){
                bean = new ImagePropsBean();
                bean.setImageId(outBean.getImagepropslist().get(j).getImageid());
                bean.setKouteikanriid(outBean.getImagepropslist().get(j).getGyoumukey());
                bean.setTorikomiSyoruiCd(outBean.getImagepropslist().get(j).getTorikomisyoruicd());
                bean.setDispTorikomiSyoruiNm(C_SyoruiCdKbn.getContentByValue(bean.getTorikomiSyoruiCd()));
                bean.setSyoruiTtykYmdTime(outBean.getImagepropslist().get(j).getSyoruitoutyakutime());
                bean.setKouteiStatus(outBean.getImagepropslist().get(j).getKouteijyoutai());
                bean.setKengenUmu(outBean.getImagepropslist().get(j).getKengenumu());
                WKAPI.add(bean);
            }
        }


        List<SyoruiJohoItiranBean> beanList = new ArrayList<SyoruiJohoItiranBean>();
        SyoruiJohoItiranBean bean;
        for(int i=0; i<WKAPI.size(); i++){
            bean = new SyoruiJohoItiranBean();

            bean.setSyoruiNnm(WKAPI.get(i).getDispTorikomiSyoruiNm());
            bean.setSyoruiTtykYmdTime(WKAPI.get(i).getSyoruiTtykYmdTime());
            bean.setHituyouSyorui("");

            bean.setHyoujiLink("1");

            bean.setImageId(WKAPI.get(i).getImageId());
            bean.setTorikomiSyoruiCd(WKAPI.get(i).getTorikomiSyoruiCd());
            bean.setHyoujiLinkFlg(WKAPI.get(i).getKengenUmu());
            bean.setKouteikanriId(WKAPI.get(i).getKouteikanriid());
            bean.setSortNo(sortNoMap.get(WKAPI.get(i).getTorikomiSyoruiCd()));

            beanList.add(bean);
        }



        HashSet<String> mitoutyakuSyoruiSet = Sets.newHashSet();
        boolean existsFlg = false;
        for (int i = WKTBL1.size() - 1; i >= 0; i--) {
            for (int j = 0; j < WKAPI.size(); j++) {
                if (WKTBL1.get(i).getKouteikanriid().equals(WKAPI.get(j).getKouteikanriid()) &&
                        WKTBL1.get(i).getSyoruiCd().equals(C_SyoruiCdKbn.valueOf(WKAPI.get(j).getTorikomiSyoruiCd()))) {

                    beanList.get(j).setHituyouSyorui(SyoruiResultConstants.HITUYO_SYORUI);
                    existsFlg = true;
                }
            }

            if(!existsFlg){
                mitoutyakuSyoruiSet.add(WKTBL1.get(i).getKouteikanriid()
                        + SyoruiResultConstants.SPLITTER
                        + WKTBL1.get(i).getSyoruiCd().getValue());
            } else {
                existsFlg = false;
            }
        }


        Iterator<String> ite = mitoutyakuSyoruiSet.iterator();
        String splitter = SyoruiResultConstants.ESCAPE + SyoruiResultConstants.SPLITTER;
        while(ite.hasNext()){
            String[] mitoutyakuSyoruiArray = ite.next().split(splitter);
            String kouteiKanriId = mitoutyakuSyoruiArray[0];
            String syoruiCd = mitoutyakuSyoruiArray[1];
            bean = new SyoruiJohoItiranBean();

            bean.setSyoruiNnm(C_SyoruiCdKbn.getContentByValue(syoruiCd));
            bean.setSyoruiTtykYmdTime("");
            bean.setHituyouSyorui(SyoruiResultConstants.HITUYO_SYORUI);
            bean.setHyoujiLink("");
            bean.setImageId("");
            bean.setTorikomiSyoruiCd(syoruiCd);
            bean.setHyoujiLinkFlg(SyoruiResultConstants.DISPLINK_NOT);
            bean.setKouteikanriId(kouteiKanriId);
            bean.setSortNo(sortNoMap.get(syoruiCd));
            beanList.add(bean);
        }



        Ordering<SyoruiJohoItiranBean> ordering = Ordering.from(new MyBeanIdAscNoDescComparator());
        List<SyoruiJohoItiranBean> sortedList = ordering.sortedCopy(beanList);

        Out.setSyoruiJohoItiranBeanList(sortedList);


        for(int n = 0; n < sortedList.size(); n++){
            logger.debug("["+n+"]書類名=" + sortedList.get(n).getSyoruiNnm());
            logger.debug("["+n+"]書類到着日時=" + sortedList.get(n).getSyoruiTtykYmdTime());
            logger.debug("["+n+"]必要書類=" + sortedList.get(n).getHituyouSyorui());
            logger.debug("["+n+"]表示リンク=" + sortedList.get(n).getHyoujiLink());
            logger.debug("["+n+"]イメージID=" + sortedList.get(n).getImageId());
            logger.debug("["+n+"]取込書類コード=" + sortedList.get(n).getTorikomiSyoruiCd());
            logger.debug("["+n+"]表示リンクフラグ=" + sortedList.get(n).getHyoujiLinkFlg());
            logger.debug("["+n+"]工程管理ＩＤ=" + sortedList.get(n).getKouteikanriId());
            logger.debug("["+n+"]ソート番号=" + sortedList.get(n).getSortNo());
        }



        Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_OK);
        Out.setSyousaiMessageCd(null);
        Out.setSyousaiMessage(null);

        return Out;
    }


    public static GetSyoruiJohoItiranListResultBean getSyoruiJouhouItiranBetu(
            String[] pKouteikanriIds) {
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        String kinouId = kinou.getKinouId();

        HashSet<String> syoruiCdKbnSet = getSyoruiCdItiranSetByKinouId(kinouId);

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfoList = bizDomManager.getAllTorikomiSyoruiHukaInfo();

        Map<String, Integer> sortNoMap = new HashMap<String, Integer>();

        for (BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo : torikomiSyoruiHukaInfoList) {
            sortNoMap.put(torikomiSyoruiHukaInfo.getSyoruiCd().getValue(), torikomiSyoruiHukaInfo.getSortNo());
        }

        List<String> syuKouteikanriIdList = new ArrayList<String>();

        for (int i = 0; i < pKouteikanriIds.length; i++) {
            syuKouteikanriIdList.add(pKouteikanriIds[i]);
        }

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = new ArrayList<BT_HituyouSyoruiKanri>();

        Map<String, String> jimMap = new HashMap<String, String>();

        for (int i = 0; i < syuKouteikanriIdList.size(); i++) {
            BT_GyoumuKouteiInfo wkGyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(syuKouteikanriIdList.get(i));

            hituyouSyoruiKanriList.addAll(bizDomManager.getGyoumuKouteiInfo(syuKouteikanriIdList.get(i))
                    .getHituyouSyoruiKanris());

            jimMap.put(syuKouteikanriIdList.get(i), wkGyoumuKouteiInfo.getJimutetuzukicd());
        }

        SortBT_HituyouSyoruiKanri sortBT_HituyouSyoruiKanri = SWAKInjector.getInstance(SortBT_HituyouSyoruiKanri.class);
        hituyouSyoruiKanriList = sortBT_HituyouSyoruiKanri.OrderBT_HituyouSyoruiKanriByPkAsc(hituyouSyoruiKanriList);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList2 = Lists.newArrayList();

        for (int i = 0; i < hituyouSyoruiKanriList.size(); i++) {
            BT_HituyouSyoruiKanri hituyouSyoruiKanri = new BT_HituyouSyoruiKanri();

            hituyouSyoruiKanri.setKouteikanriid(hituyouSyoruiKanriList.get(i).getKouteikanriid());
            hituyouSyoruiKanri.setSyoruiCd(hituyouSyoruiKanriList.get(i).getSyoruiCd());

            hituyouSyoruiKanriList2.add(hituyouSyoruiKanri);
        }

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        BaseUserInfo baseUserInfo = SWAKInjector.getInstance(BaseUserInfo.class);
        GetSyoruiJohoItiranListResultBean getSyoruiJohoItiranListResultBean = SWAKInjector
                .getInstance(GetSyoruiJohoItiranListResultBean.class);

        List<ImagePropsBean> imagePropsBeanList2 = Lists.newArrayList();

        for (String syuKouteikanriId: syuKouteikanriIdList) {
            GetImagePropsInBean getImagePropsInBean = SWAKInjector.getInstance(GetImagePropsInBean.class);

            getImagePropsInBean.setAccountid(baseUserInfo.getUserId());
            getImagePropsInBean.setGyoumukey(syuKouteikanriId);
            getImagePropsInBean.setFlowid(jimMap.get(syuKouteikanriId));

            GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

            getSyoruiJohoItiranListResultBean.setSyousaiMessageCd(getImagePropsOutBean.getSyousaimsgcd());
            getSyoruiJohoItiranListResultBean.setSyousaiMessage(getImagePropsOutBean.getSyousaimsg());

            if (!(getImagePropsOutBean.getKekkastatus().equals(SyoruiResultConstants.RESULT_OK))) {
                if (getImagePropsOutBean.getSyousaimsgcd().equals("IWF9004")) {
                    continue;
                }
                getSyoruiJohoItiranListResultBean.setSyorikekkaStatus(getImagePropsOutBean.getKekkastatus());

                return getSyoruiJohoItiranListResultBean;
            }

            for ( int i = 0; i < getImagePropsOutBean.getImagepropslist().size(); i++) {
                ImagePropsBean imagePropsBean = SWAKInjector.getInstance(ImagePropsBean.class);

                imagePropsBean.setImageId(getImagePropsOutBean.getImagepropslist().get(i).getImageid());
                imagePropsBean.setKouteikanriid(getImagePropsOutBean.getImagepropslist().get(i).getGyoumukey());
                imagePropsBean.setTorikomiSyoruiCd(getImagePropsOutBean.getImagepropslist().get(i).getTorikomisyoruicd());
                imagePropsBean.setDispTorikomiSyoruiNm(C_SyoruiCdKbn.getContentByValue(imagePropsBean.getTorikomiSyoruiCd()));
                imagePropsBean.setSyoruiTtykYmdTime(getImagePropsOutBean.getImagepropslist().get(i).getSyoruitoutyakutime());
                imagePropsBean.setKouteiStatus(getImagePropsOutBean.getImagepropslist().get(i).getKouteijyoutai());
                imagePropsBean.setKengenUmu(getImagePropsOutBean.getImagepropslist().get(i).getKengenumu());

                imagePropsBeanList2.add(imagePropsBean);
            }
        }

        HashSet<String> mitoutyakuSyoruiSet = Sets.newHashSet();
        List<SyoruiJohoItiranBean> syoruiJohoItiranBeanList = new ArrayList<SyoruiJohoItiranBean>();

        for (ImagePropsBean imagePropsBean : imagePropsBeanList2) {
            if (syoruiCdKbnSet.contains(imagePropsBean.getTorikomiSyoruiCd())) {
                SyoruiJohoItiranBean syoruiJohoItiranBean = new SyoruiJohoItiranBean();

                syoruiJohoItiranBean.setSyoruiNnm(imagePropsBean.getDispTorikomiSyoruiNm());
                syoruiJohoItiranBean.setSyoruiTtykYmdTime(imagePropsBean.getSyoruiTtykYmdTime());
                syoruiJohoItiranBean.setHituyouSyorui("");
                syoruiJohoItiranBean.setHyoujiLink("1");
                syoruiJohoItiranBean.setImageId(imagePropsBean.getImageId());
                syoruiJohoItiranBean.setTorikomiSyoruiCd(imagePropsBean.getTorikomiSyoruiCd());

                if ("0".equals(imagePropsBean.getKengenUmu())) {
                    syoruiJohoItiranBean.setHyoujiLinkFlg("0");
                }
                else {
                    syoruiJohoItiranBean.setHyoujiLinkFlg("1");
                }

                syoruiJohoItiranBean.setKouteikanriId(imagePropsBean.getKouteikanriid());
                syoruiJohoItiranBean.setSortNo(sortNoMap.get(imagePropsBean.getTorikomiSyoruiCd()));

                syoruiJohoItiranBeanList.add(syoruiJohoItiranBean);
            }
        }

        for (BT_HituyouSyoruiKanri hituyouSyoruiKanri : hituyouSyoruiKanriList2) {

            boolean existsFlg = false;

            for (SyoruiJohoItiranBean syoruiJohoItiranBean : syoruiJohoItiranBeanList) {
                if (hituyouSyoruiKanri.getKouteikanriid().equals(syoruiJohoItiranBean.getKouteikanriId()) &&
                        hituyouSyoruiKanri.getSyoruiCd().getValue().equals(syoruiJohoItiranBean.getTorikomiSyoruiCd())) {
                    syoruiJohoItiranBean.setHituyouSyorui(SyoruiResultConstants.HITUYO_SYORUI);
                    existsFlg = true;
                }
            }
            if(!existsFlg){
                mitoutyakuSyoruiSet.add(hituyouSyoruiKanri.getKouteikanriid()
                        + SyoruiResultConstants.SPLITTER + hituyouSyoruiKanri.getSyoruiCd().getValue());
            } else {
                existsFlg = false;
            }
        }

        Iterator<String> ite = mitoutyakuSyoruiSet.iterator();
        String splitter = SyoruiResultConstants.ESCAPE + SyoruiResultConstants.SPLITTER;
        while (ite.hasNext()) {
            String[] mitoutyakuSyoruiArray = ite.next().split(splitter);
            String kouteiKanriId = mitoutyakuSyoruiArray[0];
            String syoruiCd = mitoutyakuSyoruiArray[1];
            if (syoruiCdKbnSet.contains(syoruiCd)) {
                SyoruiJohoItiranBean syoruiJohoItiranBean = new SyoruiJohoItiranBean();

                syoruiJohoItiranBean.setSyoruiNnm(C_SyoruiCdKbn.getContentByValue(syoruiCd));
                syoruiJohoItiranBean.setSyoruiTtykYmdTime("");
                syoruiJohoItiranBean.setHituyouSyorui(SyoruiResultConstants.HITUYO_SYORUI);
                syoruiJohoItiranBean.setHyoujiLink("");
                syoruiJohoItiranBean.setImageId("");
                syoruiJohoItiranBean.setTorikomiSyoruiCd(syoruiCd);
                syoruiJohoItiranBean.setHyoujiLinkFlg(SyoruiResultConstants.DISPLINK_NOT);
                syoruiJohoItiranBean.setKouteikanriId(kouteiKanriId);
                syoruiJohoItiranBean.setSortNo(sortNoMap.get(syoruiCd));

                syoruiJohoItiranBeanList.add(syoruiJohoItiranBean);
            }

        }

        Ordering<SyoruiJohoItiranBean> ordering = Ordering.from(new MyBeanIdAscNoDescComparator());
        List<SyoruiJohoItiranBean> sortedList = ordering.sortedCopy(syoruiJohoItiranBeanList);

        getSyoruiJohoItiranListResultBean.setSyoruiJohoItiranBeanList(sortedList);

        for (int n = 0; n < sortedList.size(); n++) {
            logger.debug("[" + n + "]書類名=" + sortedList.get(n).getSyoruiNnm());
            logger.debug("[" + n + "]書類到着日時=" + sortedList.get(n).getSyoruiTtykYmdTime());
            logger.debug("[" + n + "]必要書類=" + sortedList.get(n).getHituyouSyorui());
            logger.debug("[" + n + "]表示リンク=" + sortedList.get(n).getHyoujiLink());
            logger.debug("[" + n + "]イメージID=" + sortedList.get(n).getImageId());
            logger.debug("[" + n + "]取込書類コード=" + sortedList.get(n).getTorikomiSyoruiCd());
            logger.debug("[" + n + "]表示リンクフラグ=" + sortedList.get(n).getHyoujiLinkFlg());
            logger.debug("[" + n + "]工程管理ＩＤ=" + sortedList.get(n).getKouteikanriId());
            logger.debug("[" + n + "]ソート番号=" + sortedList.get(n).getSortNo());
        }

        getSyoruiJohoItiranListResultBean.setSyorikekkaStatus(SyoruiResultConstants.RESULT_OK);
        getSyoruiJohoItiranListResultBean.setSyousaiMessageCd(null);
        getSyoruiJohoItiranListResultBean.setSyousaiMessage(null);

        return getSyoruiJohoItiranListResultBean;
    }





    public static DispImageResultBean dispImage(String[] pImageId) {

        BaseUserInfo baseUserInfo = SWAKInjector.getInstance(BaseUserInfo.class);



        DispImageResultBean Out = new DispImageResultBean();

        GetImageInBean inBean = new GetImageInBean();
        String[] imageIds = new String[pImageId.length];
        String userId = baseUserInfo.getUserId();

        imageIds = pImageId;
        inBean.setImageids(imageIds);
        inBean.setAccountid(userId);



        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        WSGetImageByIdResponse outBean = iwfImageClient.execGetImage(inBean);

        Out.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        Out.setSyousaiMessage(outBean.getSyousaimsg());

        if (!SyoruiResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            Out.setSyorikekkaStatus(outBean.getKekkastatus());
            return Out;
        }

        if (outBean.getImageinfolist().size() <= 0) {
            Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_NODATA);
            return Out;
        }


        if (outBean.getImageinfolist() != null &&
                outBean.getImageinfolist().size() > 0) {
            logger.debug("重複除去前 イメージID");

            Map<String,ImageInfoBean> wkImageIdMap = new HashMap<>();
            for(ImageInfoBean wkImageInfoBean : outBean.getImageinfolist()){
                logger.debug(wkImageInfoBean.getImageid());
                wkImageIdMap.put(wkImageInfoBean.getImageid(), wkImageInfoBean);
            }

            logger.debug("重複除去後 イメージID");
            logger.debug(wkImageIdMap.keySet().toString());

            ArrayList<ImageInfoBean> wkImageInfoList = new ArrayList<>(wkImageIdMap.values());
            outBean.setImageinfolist(wkImageInfoList);

        }

        if (outBean.getImageinfolist() != null &&
                outBean.getImageinfolist().size() > 0) {

            List<WkImageInfoBean> wkImageInfoBeanList = new ArrayList<WkImageInfoBean>();


            BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

            List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfoList = bizDomManager.getAllTorikomiSyoruiHukaInfo();

            Map<String, Integer> sortNoMap = new HashMap<String, Integer>();

            for(BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo : torikomiSyoruiHukaInfoList){

                sortNoMap.put(torikomiSyoruiHukaInfo.getSyoruiCd().getValue(), torikomiSyoruiHukaInfo.getSortNo());
            }

            ArrayList<ImageInfoBean> imageInfoBeanList = outBean.getImageinfolist();
            for(ImageInfoBean imageInfoBean : imageInfoBeanList){

                WkImageInfoBean wkImageInfoBean = new WkImageInfoBean();

                wkImageInfoBean.setSortNo(sortNoMap.get(imageInfoBean.getTorikomisyoruicd()));
                wkImageInfoBean.setSyoruitoutyakutime(imageInfoBean.getSyoruitoutyakutime());
                wkImageInfoBean.setPdfimage(imageInfoBean.getPdfimage());

                wkImageInfoBeanList.add(wkImageInfoBean);
            }

            Ordering<WkImageInfoBean> ordering = Ordering.from(new SyoruiImageResultBeanSortComparator());
            wkImageInfoBeanList = ordering.sortedCopy(wkImageInfoBeanList);

            PdfBuilder pb = new PdfBuilder();
            ByteArrayOutputStream oBaos = new ByteArrayOutputStream();

            for(WkImageInfoBean wkImageInfoBean : wkImageInfoBeanList){

                byte[] pdfImage = wkImageInfoBean.getPdfimage();

                try{
                    pb.append(new PdfReader(pdfImage));

                }catch (Exception e1) {
                    logger.error("書類取得イメージ表示（PDFリーダ作成異常）");
                    logger.error("エラーコード："+ SyoruiResultConstants.MSGCD_EAS0017);
                    logger.error("エラーメッセージ："+ SyoruiResultConstants.MSG_EAS0017);
                    Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_NG);
                    Out.setSyousaiMessageCd(SyoruiResultConstants.MSGCD_EAS0017);
                    Out.setSyousaiMessage(SyoruiResultConstants.MSG_EAS0017);
                    return Out;
                }

                logger.debug("PdfBuilder END\n");
            }

            try {
                PdfReader pr = new PdfReader(pb.toByteArray());
                PdfUtil.encrypt(pr , oBaos);
            } catch (IOException e1) {
                logger.error("書類取得イメージ表示（PDFリーダ作成異常）");
                logger.error("エラーコード："+ SyoruiResultConstants.MSGCD_EAS0017);
                logger.error("エラーメッセージ："+ SyoruiResultConstants.MSG_EAS0017);
                Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_NG);
                Out.setSyousaiMessageCd(SyoruiResultConstants.MSGCD_EAS0017);
                Out.setSyousaiMessage(SyoruiResultConstants.MSG_EAS0017);
                return Out;
            }

            logger.debug("PdfReader END\n");

            HttpServletResponse resp = SWAKInjector.getInstance(HttpServletResponse.class);

            resp.reset();
            resp.setContentType("application/pdf");
            resp.setContentLength(oBaos.toByteArray().length);
            resp.setHeader("Content-Disposition", "inline; filename=\"" + "Syorui" + ".pdf\";");
            try {
                resp.getOutputStream().write(oBaos.toByteArray());
            } catch (IOException e) {
                logger.error("書類取得イメージ表示（ストリーム出力異常）");
                logger.error("エラーコード："+ SyoruiResultConstants.MSGCD_EAS0007);
                logger.error("エラーメッセージ："+ SyoruiResultConstants.MSG_EAS0007);

                Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_NG);
                Out.setSyousaiMessageCd(SyoruiResultConstants.MSGCD_EAS0007);
                Out.setSyousaiMessage(SyoruiResultConstants.MSG_EAS0007);
                return Out;

            }

        }

        Out.setSyorikekkaStatus(SyoruiResultConstants.RESULT_OK);
        Out.setSyousaiMessageCd("IWF0000");
        Out.setSyousaiMessage("処理終了");

        return Out;

    }

    private static HashSet<String> getSyoruiCdItiranSetByKinouId(String pKinouId) {
        HashSet<String> syoruiCdSet = new HashSet<String>();

        if (SyoruiResultConstants.SKMOUSIKOMISYO.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKKOKUTISYO.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
        }
        else if (SyoruiResultConstants.SKMOUSIKOMITENKEN.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKMOUSIKOMITORIKESI.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKKANKYOUSATEI.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKIMUSATEI.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
        }
        else if (SyoruiResultConstants.SKKEIYAKUKAKUNINKEKKA.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
        }
        else if (SyoruiResultConstants.SKHENKINKIBOU.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
        }
        else if (SyoruiResultConstants.SKHENKIN.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
        }
        else if (SyoruiResultConstants.SKMOSSYOUKAI.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKHUBITOUROKU.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }
        else if (SyoruiResultConstants.SKHUBIKAISYOU.equals(pKinouId)) {
            syoruiCdSet.add(C_SyoruiCdKbn.SK_MOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_IKOUKAKSYO_TEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HUBITUUTI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKOUTEISEI.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SONOTAHUZOKU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HENKINIRAISYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_TRKSSEIKYU.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO.getValue());
            syoruiCdSet.add(C_SyoruiCdKbn.SK_HITAIMENCHKSHEET.getValue());
        }

        return syoruiCdSet;
    }
}
