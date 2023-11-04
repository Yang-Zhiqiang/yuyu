package yuyu.common.biz.workflow;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.CreateImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeOutBean;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageInBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.image.SetImageRelationOutBean;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.common.biz.workflow.io.image.sub.ArrivalNoticeBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExtParamBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse.ImageInfoBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse.ImagePropsBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;

public class IwfImageClientMock extends IwfImageClient {
    public static String caller = null;
    public static String mode = null;


    @Override
    public WSGetImageByIdResponse execGetImage(GetImageInBean inBean){

        if("Test".equals(caller)){
            WSGetImageByIdResponse wSGetImageByIdResponse = new WSGetImageByIdResponse();
            ImageInfoBean imageInfoBean = new ImageInfoBean();
            ArrayList<ImageInfoBean> iIBeanList = new ArrayList<ImageInfoBean>();
            byte[] b = new byte[102400];
            try {
                DataInputStream dataInStream =
                        new DataInputStream(
                                new BufferedInputStream(
                                        new FileInputStream("D:/develop/temp/dummy.pdf")));
                dataInStream.read(b);
                dataInStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            switch(mode) {
                case "21-01":
                    wSGetImageByIdResponse.setKekkastatus("9");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0002");
                    wSGetImageByIdResponse.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "21-02":
                    wSGetImageByIdResponse.setKekkastatus("9");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0002");
                    wSGetImageByIdResponse.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "21-03":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-04":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-05":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-06":
                    wSGetImageByIdResponse.setKekkastatus("9");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0002");
                    wSGetImageByIdResponse.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "21-07":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-08":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-09":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "21-10":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("abcdefg");
                    imageInfoBean.setGyoumukey("");
                    imageInfoBean.setTorikomisyoruicd("");
                    imageInfoBean.setSyoruitoutyakutime("");
                    imageInfoBean.setKengenumu("");
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                case "dl01-01":
                    wSGetImageByIdResponse.setKekkastatus("9");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "dl01-02":
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
                default:
                    wSGetImageByIdResponse.setKekkastatus("0");
                    wSGetImageByIdResponse.setSyousaimsgcd("IWF0000");
                    wSGetImageByIdResponse.setSyousaimsg("正常終了しました。");
                    imageInfoBean.setImageid("ImageId01");
                    imageInfoBean.setGyoumukey("GyoumuKey01");
                    imageInfoBean.setTorikomisyoruicd("SyoruiCd01");
                    imageInfoBean.setSyoruitoutyakutime(sdf.format(cal.getTime()));
                    imageInfoBean.setKengenumu("1");
                    imageInfoBean.setPdfimage(b);
                    iIBeanList.add(imageInfoBean);
                    wSGetImageByIdResponse.setImageinfolist(iIBeanList);
                    break;
            }
            return wSGetImageByIdResponse;
        }
        else{
            return super.execGetImage(inBean);
        }
    }

    @Override
    public WSPutImageResponse execPutImage(PutImageInBean inBean){

        if("Test".equals(caller)) {
            WSPutImageResponse response = new WSPutImageResponse();

            switch(mode) {
                case "22-01":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-06":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-07":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-08":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-09":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-10":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-11":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF3092");
                    response.setSyousaimsg("取込書類マスタのレコードが取得できませんでした。");
                    response.setImgid("ImageId01");
                    break;
                case "22-12":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF3091");
                    response.setSyousaimsg("プロセス定義が取得できませんでした。");
                    response.setImgid("ImageId01");
                    break;
                case "22-13":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-14":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-15":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-16":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-17":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-18":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-19":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-20":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-21":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    response.setImgid("ImageId01");
                    break;
                case "22-22":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-23":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
                case "22-24":
                    super.execPutImage(inBean);
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    response.setImgid("ImageId01");
                    break;
                case "22-25":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF2051");
                    response.setSyousaimsg("指定された業務キー、フローIDに紐付くトークンは、既に存在しています。");
                    response.setImgid("ImageId01");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImgid("ImageId01");
                    break;
            }
            return response;
        } else {
            return super.execPutImage(inBean);
        }
    }

    @Override
    public WSExecProcessCreateResponse execCreateImageSpace(CreateImageSpaceInBean inBean) {

        if("Test".equals(caller)) {
            WSExecProcessCreateResponse response = new WSExecProcessCreateResponse();

            switch(mode) {
                case "22-01":
                    response.setKekkastatus("99");
                    break;
                case "22-02":
                    response.setKekkastatus("98");
                    break;
                case "22-03":
                    response.setKekkastatus("97");
                    break;
                case "22-04":
                    response.setKekkastatus("96");
                    break;
                case "22-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-06":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-09":
                    response.setKekkastatus("95");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-10":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "22-11":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-12":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-13":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-14":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-15":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-16":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-17":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-18":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-19":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2052");
                    response.setSyousaimsg("アカウントIDが取得できませんでした。");
                    break;
                case "22-20":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-21":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-22":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-23":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-24":
                    super.execCreateImageSpace(inBean);
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2051");
                    response.setSyousaimsg("指定された業務キー、フローIDに紐付くトークンは、既に存在しています。");
                    break;
                case "22-25":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2051");
                    response.setSyousaimsg("指定された業務キー、フローIDに紐付くトークンは、既に存在しています。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execCreateImageSpace(inBean);
        }
    }

    @Override
    public WSExecProcessCancelResponse execDeleteImageSpace(DeleteImageSpaceInBean inBean) {

        if("Test".equals(caller)) {
            WSExecProcessCancelResponse response = new WSExecProcessCancelResponse();

            switch(mode) {
                case "22-20":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-21":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "22-22":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2190");
                    response.setSyousaimsg("指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。");
                    break;
                case "22-23":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execDeleteImageSpace(inBean);
        }
    }

    @Override
    public GetKouteiSiteiImagePropsOutBean GetKouteiSiteiImageProps(GetKouteiSiteiImagePropsInBean inBean) {

        if("Test".equals(caller)) {
            GetKouteiSiteiImagePropsOutBean response = new GetKouteiSiteiImagePropsOutBean();
            WSGetKouteiSiteiImagePropsResponse.ImagePropsBean imagePropsBean = new WSGetKouteiSiteiImagePropsResponse.ImagePropsBean();
            ArrayList<WSGetKouteiSiteiImagePropsResponse.ImagePropsBean> imagePropsBeanList = new ArrayList<>();
            ExtParamBean extParamBean = new ExtParamBean();

            switch(mode) {
                case "20-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "20-02":
                    response.setImagepropslist(imagePropsBeanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-03":
                    imagePropsBean.setFlowid("0001");
                    imagePropsBean.setGyoumukey("GyoumuKey01");
                    imagePropsBean.setTorikomisyoruicd("wf001");
                    imagePropsBean.setSyoruitoutyakutime("20160715120103");
                    imagePropsBean.setKouteijyoutai("10");
                    imagePropsBean.setKengenumu("1");
                    imagePropsBean.setTourokuaccountid("UserId01");
                    imagePropsBean.setImageid("Imageid01");
                    imagePropsBean.setTourokutime("20160716120103");
                    extParamBean.setExtparam12("17806000013");
                    extParamBean.setExtparam13("17807000016");
                    extParamBean.setExtparam14("860000017");
                    imagePropsBean.setExtparamBean(extParamBean);
                    imagePropsBeanList.add(imagePropsBean);

                    imagePropsBean = new WSGetKouteiSiteiImagePropsResponse.ImagePropsBean();
                    extParamBean = new ExtParamBean();
                    imagePropsBean.setFlowid("0002");
                    imagePropsBean.setGyoumukey("GyoumuKey02");
                    imagePropsBean.setTorikomisyoruicd("wf002");
                    imagePropsBean.setSyoruitoutyakutime("20160716120103");
                    imagePropsBean.setKouteijyoutai("10");
                    imagePropsBean.setKengenumu("1");
                    imagePropsBean.setTourokuaccountid("UserId02");
                    imagePropsBean.setImageid("Imageid02");
                    imagePropsBean.setTourokutime("20160716120103");
                    extParamBean.setExtparam12("17806000012");
                    extParamBean.setExtparam13("17807000017");
                    extParamBean.setExtparam14("860000016");
                    imagePropsBean.setExtparamBean(extParamBean);
                    imagePropsBeanList.add(imagePropsBean);

                    imagePropsBean = new WSGetKouteiSiteiImagePropsResponse.ImagePropsBean();
                    extParamBean = new ExtParamBean();
                    imagePropsBean.setFlowid("0004");
                    imagePropsBean.setGyoumukey("GyoumuKey04");
                    imagePropsBean.setTorikomisyoruicd("Ba001");
                    imagePropsBean.setSyoruitoutyakutime("20160714120103");
                    imagePropsBean.setKouteijyoutai("10");
                    imagePropsBean.setKengenumu("1");
                    imagePropsBean.setTourokuaccountid("UserId04");
                    imagePropsBean.setImageid("Imageid04");
                    imagePropsBean.setTourokutime("20160716120103");
                    extParamBean.setExtparam12("17806000015");
                    extParamBean.setExtparam13("17807000018");
                    extParamBean.setExtparam14("860000019");
                    imagePropsBean.setExtparamBean(extParamBean);
                    imagePropsBeanList.add(imagePropsBean);

                    imagePropsBean = new WSGetKouteiSiteiImagePropsResponse.ImagePropsBean();
                    extParamBean = new ExtParamBean();
                    imagePropsBean.setFlowid("0005");
                    imagePropsBean.setGyoumukey("GyoumuKey05");
                    imagePropsBean.setTorikomisyoruicd("Bb003");
                    imagePropsBean.setSyoruitoutyakutime("20160714120103");
                    imagePropsBean.setKouteijyoutai("10");
                    imagePropsBean.setKengenumu("1");
                    imagePropsBean.setTourokuaccountid("UserId05");
                    imagePropsBean.setImageid("Imageid05");
                    imagePropsBean.setTourokutime("20160716120103");
                    extParamBean.setExtparam12("17806000015");
                    extParamBean.setExtparam13("17807000018");
                    extParamBean.setExtparam14("860000019");
                    imagePropsBean.setExtparamBean(extParamBean);
                    imagePropsBeanList.add(imagePropsBean);

                    response.setImagepropslist(imagePropsBeanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    break;
                case "20-071":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    break;
                case "20-072":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0002");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }

            return response;

        } else {
            return super.GetKouteiSiteiImageProps(inBean);
        }
    }

    @Override
    public WSDropImageByIdResponse execDropImage(DropImageInBean inBean) {

        if("Test".equals(caller)) {
            WSDropImageByIdResponse response = new WSDropImageByIdResponse();
            switch(mode) {
                case "23-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "23-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー");
                    break;
                case "23-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "23-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "23-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "23-06":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execDropImage(inBean);
        }
    }

    @Override
    public GetImagePropsOutBean execGetImageProps(GetImagePropsInBean inBean) {
        if("Test".equals(caller)) {
            GetImagePropsOutBean response = new GetImagePropsOutBean();
            ArrayList<ImagePropsBean> beanList = new ArrayList<ImagePropsBean>();
            ImagePropsBean bean = new ImagePropsBean();

            switch(mode) {
                case "20-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "20-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-04":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-05":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-06":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "20-08":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-09":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-10":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-11":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-12":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-13":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf009");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf010");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-14":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-15":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-16":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-17":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf009");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-18":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf009");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-19":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf009");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-22":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-23":
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf009");
                    bean.setSyoruitoutyakutime("20150715010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-24":

                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20160111151630111");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("1");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-25":

                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20160112132005333");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("1");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20160113082650444");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("2");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-26":

                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20160227102556000");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("1");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("");
                    bean.setSyoruitoutyakutime("20160228102556111");
                    bean.setKouteijyoutai("");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("2");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId03");
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setTorikomisyoruicd(null);
                    bean.setSyoruitoutyakutime("20160229102556222");
                    bean.setKouteijyoutai(null);
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    bean.setPagecount("3");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-27":

                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "20-28":

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    response.setImagepropslist(beanList);
                    break;
                case "20-29":
                    if ("0001".equals(inBean.getFlowid())) {
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey01");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                    }
                    else if ("0002".equals(inBean.getFlowid())) {
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey02");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                    }
                    else {
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey03");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                    }
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "20-30":
                    if ("0001".equals(inBean.getFlowid())) {
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey01");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                        bean = new ImagePropsBean();
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey02");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                    }
                    else  {
                        bean.setImageid("");
                        bean.setGyoumukey("GyoumuKey03");
                        bean.setTorikomisyoruicd("");
                        bean.setSyoruitoutyakutime("");
                        bean.setKouteijyoutai("");
                        bean.setKengenumu("");
                        bean.setTourokuaccountid("");
                        beanList.add(bean);
                    }
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "dl-01":

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "dl-02":

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203003");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test1");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150717010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test2");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId03");
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setTorikomisyoruicd("wf003");
                    bean.setSyoruitoutyakutime("20150717010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test3");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId04");
                    bean.setGyoumukey("GyoumuKey04");
                    bean.setTorikomisyoruicd("wf004");
                    bean.setSyoruitoutyakutime("20150715010203002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test4");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "dl-03":

                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    break;
                case "dl-04":

                    super.execGetImageProps(inBean);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    break;
                case "dl-05":

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    break;
                case "dl-06":

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20150716010203003");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test1");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("wf002");
                    bean.setSyoruitoutyakutime("20150717010203004");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test2");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId03");
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setTorikomisyoruicd("wf003");
                    bean.setSyoruitoutyakutime("20150715010203002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test3");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId04");
                    bean.setGyoumukey("GyoumuKey04");
                    bean.setTorikomisyoruicd("wf004");
                    bean.setSyoruitoutyakutime("20150715010203002");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test4");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;

                case "qs-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    break;

                case "qs-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-03":
                    bean = new ImagePropsBean();
                    bean.setImageid(null);
                    bean.setGyoumukey(null);
                    bean.setTorikomisyoruicd("wf001");
                    bean.setKouteijyoutai(null);
                    bean.setKengenumu(null);
                    bean.setSyoruitoutyakutime(null);
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("cm021");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20160503101112000");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId03");
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setTorikomisyoruicd("hk001");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20160521101112999");
                    beanList.add(bean);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-04":
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId04");
                    bean.setGyoumukey("sk011");
                    bean.setTorikomisyoruicd("sk011");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20160521101112999");
                    beanList.add(bean);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-05":
                    bean = new ImagePropsBean();
                    bean.setImageid("");
                    bean.setGyoumukey("GyoumuKey05");
                    bean.setTorikomisyoruicd("sk007");
                    bean.setKengenumu("0");
                    bean.setSyoruitoutyakutime("20160523101112567");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId06");
                    bean.setGyoumukey("GyoumuKey05");
                    bean.setTorikomisyoruicd("sk008");
                    beanList.add(bean);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-06":
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId07");
                    bean.setGyoumukey("cm021");
                    bean.setTorikomisyoruicd("cm021");
                    beanList.add(bean);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-07":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk001");
                    bean.setTorikomisyoruicd("sk001");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-08":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk004");
                    bean.setTorikomisyoruicd("sk003");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("0");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-09":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk007");
                    bean.setTorikomisyoruicd("sk007");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-10":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk008");
                    bean.setTorikomisyoruicd("sk008");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-11":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk013");
                    bean.setTorikomisyoruicd("sk013");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-12":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("gyoumukey1");
                    bean.setTorikomisyoruicd("sk033");
                    bean.setSyoruitoutyakutime("20160523010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("gyoumukey2");
                    bean.setTorikomisyoruicd("sk033");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-13":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("nk005");
                    bean.setTorikomisyoruicd("nk005");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);


                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-14":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk071");
                    bean.setTorikomisyoruicd("sk071");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-15":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sr001");
                    bean.setTorikomisyoruicd("sr001");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);


                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-16":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId1");
                    bean.setGyoumukey("sk009");
                    bean.setTorikomisyoruicd("sk009");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);


                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-99":

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId");
                    bean.setGyoumukey("gyoumukey1");
                    bean.setTorikomisyoruicd("kk001");
                    bean.setSyoruitoutyakutime("20160524010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId");
                    bean.setGyoumukey("gyoumukey2");
                    bean.setTorikomisyoruicd("kk001");
                    bean.setSyoruitoutyakutime("20160523010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId");
                    bean.setGyoumukey("gyoumukey3");
                    bean.setTorikomisyoruicd("wf001");
                    bean.setSyoruitoutyakutime("20160523010201234");
                    bean.setKengenumu("1");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("");
                    bean.setGyoumukey("");
                    bean.setTorikomisyoruicd("");
                    bean.setSyoruitoutyakutime("");
                    bean.setKengenumu("");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                case "qs-100":
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("sk001");
                    bean.setKouteijyoutai("1");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20170403100112515");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("sk011");
                    bean.setKouteijyoutai("1");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20170403100116677");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId03");
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setTorikomisyoruicd("sk005");
                    bean.setKouteijyoutai("1");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20170403100217919");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId04");
                    bean.setGyoumukey("GyoumuKey04");
                    bean.setTorikomisyoruicd("sk033");
                    bean.setKouteijyoutai("1");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20170403100134988");
                    beanList.add(bean);

                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId05");
                    bean.setGyoumukey("GyoumuKey05");
                    bean.setTorikomisyoruicd("sk034");
                    bean.setKouteijyoutai("1");
                    bean.setKengenumu("1");
                    bean.setSyoruitoutyakutime("20170403100336742");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;
                case "qs-101":
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId06");
                    bean.setGyoumukey("GyoumuKey06");
                    bean.setTorikomisyoruicd("sk003");
                    bean.setKouteijyoutai("0");
                    bean.setKengenumu("0");
                    bean.setSyoruitoutyakutime("20170403100014863");
                    beanList.add(bean);

                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setImagepropslist(beanList);
                    break;

                default:
                    bean.setImageid("ImageId01");
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setTorikomisyoruicd("SyoruiCd01");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    bean = new ImagePropsBean();
                    bean.setImageid("ImageId02");
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setTorikomisyoruicd("SyoruiCd02");
                    bean.setKouteijyoutai("10");
                    bean.setKengenumu("1");
                    bean.setTourokuaccountid("test");
                    beanList.add(bean);
                    response.setImagepropslist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execGetImageProps(inBean);
        }
    }

    @Override
    public WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst(GetTorikomiSyoruiMstInBean inBean) {
        if("Test".equals(caller)) {
            WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
            ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
            TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {

                case "08":
                    response = execGetTorikomiSyoruiMst08(tmpMode[1],inBean);
                    break;

                case "20":
                    response = execGetTorikomiSyoruiMst20(tmpMode[1],inBean);
                    break;

                case "18":
                    response = execGetTorikomiSyoruiMst18(tmpMode[1],inBean);
                    break;

                case "25":
                    response = execGetTorikomiSyoruiMst25(tmpMode[1],inBean);
                    break;

                case "33":
                    response = execGetTorikomiSyoruiMst33(tmpMode[1],inBean);
                    break;

                case "35":
                    response = execGetTorikomiSyoruiMst35(tmpMode[1],inBean);
                    break;

                case "37":
                    response = execGetTorikomiSyoruiMst37(tmpMode[1],inBean);
                    break;

                case "38":
                    response = execGetTorikomiSyoruiMst38(tmpMode[1],inBean);
                    break;

                case "39":
                    response = execGetTorikomiSyoruiMst39(tmpMode[1],inBean);
                    break;


                default:
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("Jimutetuzuki01");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execGetTorikomiSyoruiMst(inBean);
        }
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst08(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "01":
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF9999");
                break;
            case "02":
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                bean.setFlowid("0001");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                bean.setFlowid("0001");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                if ("0001".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hk011");
                    bean.setNodeid("Node01");
                    bean.setTorikomisyoruinm("取込用表紙１");
                    bean.setTorikomisyoruiryaku("取込表紙１");
                    bean.setFlowid("0001");
                }
                else if ("0002".equals(inBean.getFlowid())) {
                    bean.setFlowid("0002");
                    bean.setTorikomisyoruicd("hk015");
                    bean.setTorikomisyoruinm("取込用表紙２");
                    bean.setTorikomisyoruiryaku("取込表紙２");
                }
                else if ("0003".equals(inBean.getFlowid())) {
                    bean.setFlowid("0003");
                    bean.setTorikomisyoruicd("hk031");
                    bean.setTorikomisyoruinm("取込用表紙３");
                    bean.setTorikomisyoruiryaku("取込表紙３");
                }
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst20(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {
            case "03":
                if ("wf001".equals(inBean.getTorikomisyoruicd())) {
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙０１");
                    bean.setTorikomisyoruiryaku("取込表紙1");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                }
                if ("wf002".equals(inBean.getTorikomisyoruicd())) {
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("取込用表紙０２");
                    bean.setTorikomisyoruiryaku("取込表紙2");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                }


                break;
            case "04":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "16":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "17":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "18":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "19":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst18(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "02":
                if (inBean.getFlowid() == "0001") {
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0001");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task01");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if (inBean.getFlowid() == "0002") {
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0002");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task02");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else {
                    bean.setTorikomisyoruicd("wf003");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0003");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task03");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ");
                bean.setTorikomisyoruiryaku("取込書類");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ");
                bean.setTorikomisyoruiryaku("取込書類");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0001");
                response.setSyousaimsg("異常終了しました。");
                break;
            case "06":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ");
                bean.setTorikomisyoruiryaku("取込書類");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ");
                bean.setTorikomisyoruiryaku("取込書類");
                bean.setFlowid("0001");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("Task01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                if (inBean.getFlowid() == "0001") {
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0001");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task01");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if (inBean.getFlowid() == "0002") {
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0002");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task02");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else {
                    bean.setTorikomisyoruicd("wf003");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0003");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task03");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("-1");
                response.setSyousaimsgcd("IWF9004");
                break;
            case "10":
                if (inBean.getFlowid() == "0001") {
                    bean.setTorikomisyoruicd("hk011");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0001");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task01");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if (inBean.getFlowid() == "0002") {
                    bean.setTorikomisyoruicd("hk015");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0002");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task02");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else {
                    bean.setTorikomisyoruicd("hk031");
                    bean.setTorikomisyoruinm("取込書類マスタ");
                    bean.setTorikomisyoruiryaku("取込書類");
                    bean.setFlowid("0003");
                    bean.setSyzksyoubunruiid("syoubunrui");
                    bean.setSyzkdaibunruiid("daibunrui");
                    bean.setZiphozonkbn("1");
                    bean.setKouteiseigyoumukbn("0");
                    bean.setNodeid("Task03");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;

            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst25(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "01":
                if ("0001".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("wf003");
                    bean.setTorikomisyoruinm("ワークフロー");
                    bean.setTorikomisyoruiryaku("ワーク");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "02":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz001");
                    bean.setTorikomisyoruinm("保全帳票１");
                    bean.setTorikomisyoruiryaku("保全１");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("nk003");
                    bean.setTorikomisyoruinm("年金帳票３");
                    bean.setTorikomisyoruiryaku("年金３");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz001");
                    bean.setTorikomisyoruinm("保全帳票１");
                    bean.setTorikomisyoruiryaku("保全１");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("nk003");
                    bean.setTorikomisyoruinm("年金帳票３");
                    bean.setTorikomisyoruiryaku("年金３");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                if ("0001".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz001");
                    bean.setTorikomisyoruinm("保全帳票１");
                    bean.setTorikomisyoruiryaku("保全１");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("nk003");
                    bean.setTorikomisyoruinm("年金帳票３");
                    bean.setTorikomisyoruiryaku("年金３");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz001");
                    bean.setTorikomisyoruinm("保全帳票１");
                    bean.setTorikomisyoruiryaku("保全１");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("nk003");
                    bean.setTorikomisyoruinm("年金帳票３");
                    bean.setTorikomisyoruiryaku("年金３");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf002");
                    bean.setTorikomisyoruinm("QRシール");
                    bean.setTorikomisyoruiryaku("シール");
                    bean.setFlowid("0001");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("保全帳票２");
                    bean.setTorikomisyoruiryaku("保全２");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz001");
                    bean.setTorikomisyoruinm("保全帳票１");
                    bean.setTorikomisyoruiryaku("保全１");
                    bean.setFlowid("0002");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0003".equals(inBean.getFlowid())) {
                    bean.setTorikomisyoruicd("nk003");
                    bean.setTorikomisyoruinm("年金帳票３");
                    bean.setTorikomisyoruiryaku("年金３");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("nk001");
                    bean.setTorikomisyoruinm("年金帳票１");
                    bean.setTorikomisyoruiryaku("年金１");
                    bean.setFlowid("0003");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;

            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst33(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "02":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                if ("0001".equals(inBean.getFlowid())) {
                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("wf001");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setSyzksyoubunruiid("syobun01");
                    bean.setSyzkdaibunruiid("daibun01");
                    bean.setZiphozonkbn("z01");
                    bean.setKouteiseigyoumukbn("k01");
                    bean.setFlowid("0001");
                    bean.setNodeid("JimuTetuzukiCd_1");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                } else if ("0002".equals(inBean.getFlowid())) {

                    bean = new TorikomiSyoruiBean();
                    bean.setTorikomisyoruicd("hz002");
                    bean.setTorikomisyoruinm("取込用表紙");
                    bean.setTorikomisyoruiryaku("取込表紙");
                    bean.setSyzksyoubunruiid("syobun01");
                    bean.setSyzkdaibunruiid("daibun01");
                    bean.setZiphozonkbn("z01");
                    bean.setKouteiseigyoumukbn("k01");
                    bean.setFlowid("0002");
                    bean.setNodeid("JimuTetuzukiCd_8");
                    beanList.add(bean);
                    response.setTorikomisyoruilist(beanList);
                }
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "05":

                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst35(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "02":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "09":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst37(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "01":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ");
                bean.setTorikomisyoruiryaku("取込書類");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "02":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0001");
                response.setSyousaimsg("異常終了しました。");
                break;
            case "06":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki02");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類マスタ（書類コード指定）");
                bean.setTorikomisyoruiryaku("取込書類（コード指定）");
                bean.setFlowid("Jimutetuzuki01");
                bean.setSyzksyoubunruiid("syoubunrui");
                bean.setSyzkdaibunruiid("daibunrui");
                bean.setZiphozonkbn("1");
                bean.setKouteiseigyoumukbn("0");
                bean.setNodeid("タスク名");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;

            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst38(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "01":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("Task02");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("Task01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_xxx");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("Task01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_xxx");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf000");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_xxx");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("hk001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_xxx");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_2");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("QRシール");
                bean.setTorikomisyoruiryaku("シール");
                bean.setSyzksyoubunruiid("syobun02");
                bean.setSyzkdaibunruiid("daibun02");
                bean.setZiphozonkbn("z02");
                bean.setKouteiseigyoumukbn("k02");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_2");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf003");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setSyzksyoubunruiid("syobun01");
                bean.setSyzkdaibunruiid("daibun01");
                bean.setZiphozonkbn("z01");
                bean.setKouteiseigyoumukbn("k01");
                bean.setFlowid("0001");
                bean.setNodeid("JimuTetuzukiCd_1");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;

            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    private WSGetTorikomiSyoruiMstResponse execGetTorikomiSyoruiMst39(String pMode, GetTorikomiSyoruiMstInBean inBean) {
        WSGetTorikomiSyoruiMstResponse response = new WSGetTorikomiSyoruiMstResponse();
        ArrayList<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean = new TorikomiSyoruiBean();

        switch (pMode) {

            case "01":
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込書類名01");
                bean.setTorikomisyoruiryaku("取込書類略称01");
                bean.setSyzksyoubunruiid("所属小分類ID01");
                bean.setSyzkdaibunruiid("所属大分類ID01");
                bean.setZiphozonkbn("ＺＩＰ保存区分01");
                bean.setKouteiseigyoumukbn("工程制御有無区分01");
                bean.setFlowid("0001");
                bean.setNodeid("TaskNm01");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("wf002");
                bean.setTorikomisyoruinm("取込書類名02");
                bean.setTorikomisyoruiryaku("取込書類略称02");
                bean.setSyzksyoubunruiid("所属小分類ID02");
                bean.setSyzkdaibunruiid("所属大分類ID02");
                bean.setZiphozonkbn("ＺＩＰ保存区分02");
                bean.setKouteiseigyoumukbn("工程制御有無区分02");
                bean.setFlowid("0001");
                bean.setNodeid("TaskNm01");
                beanList.add(bean);
                bean = new TorikomiSyoruiBean();
                bean.setTorikomisyoruicd("Ba001");
                bean.setTorikomisyoruinm("取込書類名03");
                bean.setTorikomisyoruiryaku("取込書類略称03");
                bean.setSyzksyoubunruiid("所属小分類ID03");
                bean.setSyzkdaibunruiid("所属大分類ID03");
                bean.setZiphozonkbn("ＺＩＰ保存区分03");
                bean.setKouteiseigyoumukbn("工程制御有無区分03");
                bean.setFlowid("0001");
                bean.setNodeid("TaskNm02");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;

            default:
                bean.setTorikomisyoruicd("wf001");
                bean.setTorikomisyoruinm("取込用表紙");
                bean.setTorikomisyoruiryaku("取込表紙");
                bean.setFlowid("Jimutetuzuki01");
                beanList.add(bean);
                response.setTorikomisyoruilist(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
        }

        return response;
    }

    @Override
    public WSCreateExpectedArrivalNoticeResponse CreateExpectedArrivalNotice(CreateExpectedArrivalNoticeInBean inBean) {
        if("Test".equals(caller)) {
            WSCreateExpectedArrivalNoticeResponse response = new WSCreateExpectedArrivalNoticeResponse();

            switch(mode) {
                case "34-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "34-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "34-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "34-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "34-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.CreateExpectedArrivalNotice(inBean);
        }
    }

    @Override
    public GetExpectedArrivalNoticeOutBean GetExpectedArrivalNotice(GetExpectedArrivalNoticeInBean inBean) {
        if("Test".equals(caller)) {
            GetExpectedArrivalNoticeOutBean response = new GetExpectedArrivalNoticeOutBean();
            ArrivalNoticeBean bean = new ArrivalNoticeBean();
            List<ArrivalNoticeBean> beanList = new ArrayList<ArrivalNoticeBean>();

            switch(mode) {
                case "35-01":
                    bean.setArriveKey("MOS12345678901234567");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-02":
                    bean.setArriveKey("MOS12345678901234568");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-03":
                    bean.setArriveKey("MOS12345678901234568");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "35-05":
                    bean.setArriveKey("YUYU12345678901234567");
                    beanList.add(bean);
                    bean = new ArrivalNoticeBean();
                    bean.setArriveKey("MOS12345678901234567");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-06":
                    bean.setArriveKey("YUYU12345678901234567");
                    beanList.add(bean);
                    bean = new ArrivalNoticeBean();
                    bean.setArriveKey("MOS12345678901234567");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-07":
                    bean.setArriveKey("YUYU12345678901234567");
                    bean.setGyoumuKey("Gyoumukey");
                    bean.setTorikomisyoruiCd("kk001");
                    bean.setFlowId("0001");
                    bean.setSubsystemId("common");
                    beanList.add(bean);
                    bean = new ArrivalNoticeBean();
                    bean.setArriveKey("MOS12345678901234567");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-09":
                    bean.setArriveKey("YUYU12345678901234567");
                    bean.setGyoumuKey("Gyoumukey");
                    bean.setTorikomisyoruiCd("kk001");
                    bean.setFlowId("0001");
                    bean.setSubsystemId("common");
                    beanList.add(bean);
                    bean = new ArrivalNoticeBean();
                    bean.setArriveKey("MOS12345678901234567");
                    beanList.add(bean);
                    response.setNoticeBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.GetExpectedArrivalNotice(inBean);
        }
    }

    @Override
    public WSPutArrivalImageResponse PutArrivalImage(PutArrivalImageInBean inBean) {

        if("Test".equals(caller)) {
            WSPutArrivalImageResponse response = new WSPutArrivalImageResponse();


            switch(mode) {
                case "36-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "36-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.PutArrivalImage(inBean);
        }
    }

    @Override
    public SetImageRelationOutBean setImageRelation(SetImageReleationInBean inBean) {

        if("Test".equals(caller)) {
            SetImageRelationOutBean response = new SetImageRelationOutBean();


            switch(mode) {
                case "dl01-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    break;
                case "dl01-01":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    break;
            }
            return response;
        }
        else {
            return (SetImageRelationOutBean)super.setImageRelation(inBean);
        }
    }
}
