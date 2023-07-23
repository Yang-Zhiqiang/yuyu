package yuyu.infr.report;


import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.dao.AT_TyouhyouHozonDao;
import yuyu.def.db.dao.AT_TyouhyouKensakuDao;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;
import yuyu.infr.exception.ReportNotFoundException;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;


/**
 * イメージ管理 DBアクセス。
 */
public class DBAOutputReport {

    public final int MAX_LIST_KENSUU = 1000;

    public static final String ENC_CHARSET    = "UTF-8";

    @Inject
    private Credentials credentials;
    @Inject
    private ReportEncryptor encryptor;
    @Inject
    private CreateReport createReport;
    @Inject
    private static Logger logger;

    public DBAOutputReport() {
    }

    List<AT_TyouhyouHozon> getTyouhyouHozonEntityByTyouhyouKeys(QAT_TyouhyouHozon pHozon, String[] pTyouhyouKeys) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);

        String where = makeWhereHozon(pHozon, pTyouhyouKeys, false);

        return tyouhyouHozonDao.select(where, pHozon);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakuEntityByTyouhyouKeys(QAT_TyouhyouKensaku pKensaku, String[] pTyouhyouKeys) {

        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        String where = makeWhereKensaku(pKensaku, pTyouhyouKeys);

        return tyouhyouKensakuDao.select(where, pKensaku);
    }

    List<AT_TyouhyouHozon> getTyouhyouHozonEntityByTyouhyouJoinKeys(String[] pTyouhyouJoinKeys) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);

        QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();
        String where = makeWhereHozon(hozon, pTyouhyouJoinKeys, true);

        return tyouhyouHozonDao.select(where, hozon);
    }

    public byte[] getPdfImages(String[] pTyouhyouKeys) {

        QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();

        List<AT_TyouhyouHozon> tyouhyouHozonList = getTyouhyouHozonEntityByTyouhyouKeys(hozon, pTyouhyouKeys);

        PdfBuilder oBldr = new PdfBuilder();
        Map<String, byte[]> keyMap = new HashMap<String, byte[]>();

        try{
            for (AT_TyouhyouHozon tyouhyouHozon : tyouhyouHozonList) {
                if(keyMap.containsKey(tyouhyouHozon.getReportKey())){

                    PdfBuilder pdfwk = new PdfBuilder();
                    pdfwk.append(new PdfReader(keyMap.get(tyouhyouHozon.getReportKey())));
                    pdfwk.append(new PdfReader(getPdfBinary(tyouhyouHozon)));

                    keyMap.put(tyouhyouHozon.getReportKey(), pdfwk.toByteArray());

                }
                else{
                    keyMap.put(tyouhyouHozon.getReportKey(), getPdfBinary(tyouhyouHozon));
                }
            }

            for (String key : pTyouhyouKeys) {
                oBldr.append(new PdfReader(keyMap.get(key)));
            }

        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0018");
        }

        keyMap.clear();
        keyMap = null;

        byte[] btResults = oBldr.toByteArray();

        if (btResults.length > 0) {
            updTyouhyouKensaku(pTyouhyouKeys, false);
        }
        return btResults;

    }

    public byte[] getPdfImagesByJoinKeys(String[] pTyouhyouJoinKeys) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);

        QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();
        String where = makeWhereHozon(hozon, pTyouhyouJoinKeys, true);

        PdfBuilder oBldr = new PdfBuilder();

        Map<String, byte[]> keyMap = new HashMap<String, byte[]>();
        List<String> tyouhyouKeyList = new ArrayList<String>();

        try{
            for (AT_TyouhyouHozon tyouhyouHozon : tyouhyouHozonDao.select(where, hozon)) {
                if(keyMap.containsKey(tyouhyouHozon.getReportKey())){

                    PdfBuilder pdfwk = new PdfBuilder();
                    pdfwk.append(new PdfReader(keyMap.get(tyouhyouHozon.getReportKey())));
                    pdfwk.append(new PdfReader(getPdfBinary(tyouhyouHozon)));

                    keyMap.put(tyouhyouHozon.getReportKey(), pdfwk.toByteArray());
                }
                else{
                    keyMap.put(tyouhyouHozon.getReportKey(), getPdfBinary(tyouhyouHozon));
                }

                tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
            }

            for (String key : tyouhyouKeyList) {

                oBldr.append(new PdfReader(keyMap.get(key)));
            }
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0015");
        }

        keyMap.clear();
        keyMap = null;

        byte[] btResults = oBldr.toByteArray();

        if (btResults.length > 0) {
            updTyouhyouKensaku(pTyouhyouJoinKeys, true);
        }
        return btResults;
    }

    @Transactional
    void delTargetReportByKey(String pTyouhyouKey) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);
        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        try{

            QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();
            String sql =
                    $SELECT + kensaku +
                    $FROM   + kensaku.AT_TyouhyouKensaku() +
                    $WHERE  + kensaku.reportKey + $EQ + "'" + pTyouhyouKey + "'";

            List<AT_TyouhyouKensaku> resultKensakuList = tyouhyouKensakuDao.select(sql, kensaku);
            if(!resultKensakuList.isEmpty()){
                tyouhyouKensakuDao.delete(resultKensakuList);
            }

            AT_TyouhyouHozon hozon = new AT_TyouhyouHozon();
            hozon.setReportKey(pTyouhyouKey);

            AT_TyouhyouHozon resultHozon = tyouhyouHozonDao.selectOne(hozon);
            if(resultHozon != null){
                tyouhyouHozonDao.delete(resultHozon);
            }
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0011");
        }
    }

    @Transactional
    void delTargetReportByJoinKey(String pTyouhyouJoinKey) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);
        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        try{
            QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();
            QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();
            String sqlHozon = makeWhereHozon(hozon, new String[]{pTyouhyouJoinKey}, true);

            List<AT_TyouhyouHozon> resultHozonList = tyouhyouHozonDao.select(sqlHozon, hozon);

            if(!resultHozonList.isEmpty()){
                List<String> tyouhyouKeyList = new ArrayList<String>();
                for(AT_TyouhyouHozon tyouhyouHozon:resultHozonList){
                    tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
                }
                String sqlKensaku = makeWhereKensaku(kensaku, tyouhyouKeyList.toArray(new String[0]));

                List<AT_TyouhyouKensaku> resultList = tyouhyouKensakuDao.select(sqlKensaku, kensaku);
                if(!resultList.isEmpty()){
                    tyouhyouKensakuDao.delete(resultList);
                }
            }
            hozon = new QAT_TyouhyouHozon();
            String sql =
                    $SELECT + hozon +
                    $FROM   + hozon.AT_TyouhyouHozon() +
                    $WHERE  + hozon.tyouhyouJoinKey.eq(pTyouhyouJoinKey);

            List<AT_TyouhyouHozon> resultList = tyouhyouHozonDao.select(sql, hozon);
            if(!resultList.isEmpty()){
                tyouhyouHozonDao.delete(resultList);
            }
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0011");
        }
    }

    @Transactional
    void updTyouhyouKensaku(String[] pTyouhyouKeys, boolean pJoinFlg) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);
        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        try{
            QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();
            QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();

            String[] tyouhyouKeys = new String[0];

            if(pJoinFlg){
                String sqlHozon = makeWhereHozon(hozon, pTyouhyouKeys, pJoinFlg);

                List<AT_TyouhyouHozon> resultHozonList = tyouhyouHozonDao.select(sqlHozon, hozon);

                if(!resultHozonList.isEmpty()){
                    List<String> tyouhyouKeyList = new ArrayList<String>();
                    for(AT_TyouhyouHozon tyouhyouHozon:resultHozonList){
                        tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
                    }
                    tyouhyouKeys = tyouhyouKeyList.toArray(new String[0]);
                }
            } else {
                tyouhyouKeys = pTyouhyouKeys;
            }

            if(tyouhyouKeys.length > 0){
                String sqlKensaku = makeWhereKensaku(kensaku, tyouhyouKeys);
                final List<AT_TyouhyouKensaku> targetList = tyouhyouKensakuDao.select(sqlKensaku, kensaku);

                for(AT_TyouhyouKensaku tyouhyouKensaku:targetList){

                    tyouhyouKensaku.setOutCount(new Integer(tyouhyouKensaku.getOutCount().intValue() + 1));
                    if(null == tyouhyouKensaku.getFirstOutYmd()){
                        tyouhyouKensaku.setFirstOutYmd(BizDate.getSysDate());
                    }
                    tyouhyouKensaku.setLastOutYmd(BizDate.getSysDate());
                    tyouhyouKensaku.setLastOutUserId(credentials.getUsername());

                }
            }
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0010");
        }
    }

    String makeWhereHozon(QAT_TyouhyouHozon pHozon, String[] pTyouhyouKeys, boolean pJoinFlg) {

        StringBuilder sbWhere = new StringBuilder();
        sbWhere.append($SELECT);
        sbWhere.append(pHozon);
        sbWhere.append($FROM);
        sbWhere.append(pHozon.AT_TyouhyouHozon());

        if (pTyouhyouKeys.length == 0) {
            throw new ReportNotFoundException("帳票キーの指定がありません。");
        } else if (pTyouhyouKeys.length == 1) {
            sbWhere.append($WHERE);
            if(pJoinFlg){
                sbWhere.append(pHozon.tyouhyouJoinKey.eq(pTyouhyouKeys[0]));
            } else {
                sbWhere.append(pHozon.reportKey.eq(pTyouhyouKeys[0]));
            }
        } else {
            sbWhere.append($WHERE);

            boolean notFirst = false;
            for(List<String> list : Lists.partition(Arrays.asList(pTyouhyouKeys),MAX_LIST_KENSUU)){
                if(notFirst){
                    sbWhere.append($OR);
                }

                if(pJoinFlg){
                    sbWhere.append(pHozon.tyouhyouJoinKey.in(list));
                } else {
                    sbWhere.append(pHozon.reportKey.in(list));
                }
                notFirst = true;
            }
        }

        if(pJoinFlg){
            sbWhere.append($ORDER_BY(pHozon.tyouhyouJoinKey.asc(),pHozon.reportKey.asc()));
        } else {
            sbWhere.append($ORDER_BY(pHozon.reportKey.asc()));
        }

        return sbWhere.toString();
    }

    String makeWhereKensaku(QAT_TyouhyouKensaku pKensaku, String[] pTyouhyouKeys) {

        StringBuilder sbWhere = new StringBuilder();

        sbWhere.append($SELECT);
        sbWhere.append(pKensaku);
        sbWhere.append($FROM);
        sbWhere.append(pKensaku.AT_TyouhyouKensaku());

        if (pTyouhyouKeys.length == 0) {
            throw new ReportNotFoundException("帳票キーの指定がありません。");
        } else if (pTyouhyouKeys.length == 1) {
            sbWhere.append($WHERE);
            sbWhere.append(pKensaku.reportKey.eq(pTyouhyouKeys[0]));
        } else {
            sbWhere.append($WHERE);

            boolean notFirst = false;
            for(List<String> list : Lists.partition(Arrays.asList(pTyouhyouKeys),MAX_LIST_KENSUU)){
                if(notFirst){
                    sbWhere.append($OR);
                }

                sbWhere.append(pKensaku.reportKey.in(list));
                notFirst = true;
            }

            sbWhere.append($ORDER_BY(pKensaku.reportKey.asc()));
        }
        return sbWhere.toString();
    }

    @SuppressWarnings("rawtypes")
    byte[] getPdfBinary(AT_TyouhyouHozon tyouhyouHozon) {

        if(tyouhyouHozon == null){
            return null;
        }

        if(null == tyouhyouHozon.getPdfHozonKbn()){
            throw new BizAppException("EAS0021");
        }

        C_YesNoKbn angoukaKbn  = tyouhyouHozon.getAngoukaKbn();

        C_YesNoKbn pdfHozonKbn = tyouhyouHozon.getPdfHozonKbn();

        C_YesNoKbn zipHozonKbn =tyouhyouHozon.getZipHozonKbn();

        byte[] pdf = tyouhyouHozon.getPdfData();

        if(C_YesNoKbn.YES.eq(angoukaKbn)){
            encryptor.setKey(tyouhyouHozon.getReportKey());
            pdf = encryptor.decode(pdf);
        }

        if(pdfHozonKbn.eq(C_YesNoKbn.YES)){
            if(zipHozonKbn.eq(C_YesNoKbn.YES)) {
                pdf = BytesSerializer.unzip(pdf);
            }
        }
        else{
            ReportServicesBean serviceBean;
            if(zipHozonKbn.eq(C_YesNoKbn.YES)) {
                serviceBean = unzipDeserialize(pdf);
            } else {
                serviceBean = deserialize(pdf);
            }
            pdf = createReport.createPdf(serviceBean);
        }
        return pdf;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] bytes) {

        try{
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            T obj = (T)ois.readObject();
            return obj;
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T unzipDeserialize(byte[] pSrc) {

        byte[] bytes = BytesSerializer.unzip(pSrc);
        if(pSrc.length > 0 && bytes.length == 0){

            bytes = pSrc;
        }
        return (T)deserialize(bytes);
    }
}
