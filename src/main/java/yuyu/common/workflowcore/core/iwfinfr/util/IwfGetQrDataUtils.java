package yuyu.common.workflowcore.core.iwfinfr.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfQRUtils.ImageFormat;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.d_project.qrcode.ErrorCorrectLevel;

/**
 * ＱＲイメージデータ取得メソッド
 */
public class IwfGetQrDataUtils {

    public static HashMap<String, byte[]> getQrData(
        final String[] psSyoruiCds, IwfCoreDomManager iwfCoreDomManager) throws Exception {

        String[] sImgCds = _getImgIds(psSyoruiCds, iwfCoreDomManager);

        if (sImgCds == null || sImgCds.length <= 0) {

            return null;
        }

        HashMap<String, byte[]> oQrCodeMap = new HashMap<String, byte[]>();
        for (String sImgCd : sImgCds) {
            byte[] image = IwfQRUtils.createQRImage(sImgCd, ImageFormat.JPEG, 2, 3, ErrorCorrectLevel.H);
            oQrCodeMap.put(sImgCd, image);
        }

        return oQrCodeMap;
    }

    private static String[] _getImgIds(final String[] psSyoruiCds, IwfCoreDomManager iwfCoreDomManager) throws Exception {

        List<WT_TorikomiKanri> oList = iwfCoreDomManager.getTorikomiKanrisBySyoruiCds(psSyoruiCds);

        List<String> oImgCd = new ArrayList<String>();

        for (WT_TorikomiKanri oTorikomi : oList) {
            System.out.println("取込管理TBL．イメージID   "+oTorikomi.getIwfImageId());
            oImgCd.add(oTorikomi.getIwfImageId());
        }

        return oImgCd.toArray(new String[oImgCd.size()]);
    }
}
