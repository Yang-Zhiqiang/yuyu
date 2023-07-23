package yuyu.infr.report;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

import com.lowagie.text.pdf.PdfReader;

/**
 * 帳票情報、帳票検索情報をＤＢに格納するためのクラスです。
 */
public class ReportEntry {

    @Inject
    private BaseDomManager manager;
    @Inject
    protected UniqueKeyGenerator uniqueKeyGenerator;
    @Inject
    private ReportEncryptor encryptor;
    @Inject
    private SyoruiZokuseiReader syoruiZokuseiReader;

    public void entry(byte[] pBytes, ReportServicesBean pBean, boolean commitFlg) {

        List<byte[]> byteList = new ArrayList<byte[]>();
        List<ReportServicesBean> beanList = new ArrayList<ReportServicesBean>();

        byteList.add(pBytes);
        beanList.add(pBean);
        entry(byteList, beanList, commitFlg);
    }


    public void entry(List<byte[]> pBytesList, List<ReportServicesBean> pBeanList, boolean commitFlg) {

        final List<AT_TyouhyouHozon> hozonList = new ArrayList<AT_TyouhyouHozon>();
        final List<AT_TyouhyouKensaku> kensakuList = new ArrayList<AT_TyouhyouKensaku>();

        int i = 0;
        for(ReportServicesBean serviceBean : pBeanList){

            C_SyoruiCdKbn syoruiCdKbn = serviceBean.getSyoruiCdKbns()[serviceBean.getSyoruiCdKbnIdx()];
            SyoruiZokusei zokusei = syoruiZokuseiReader.read().get(syoruiCdKbn.getValue());

            byte[] pdfBin = new byte[0];
            try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                String uniqueId = uniqueKeyGenerator.generateUniqueKey();

                long fileSize = 0;
                int  pageCount = 0;

                if(C_YesNoKbn.YES.eq(zokusei.getPdfHozonKbn())){

                    PdfReader reader = new PdfReader(pBytesList.get(i));

                    fileSize = reader.getFileLength();
                    pageCount = reader.getNumberOfPages();

                    PdfUtil.encrypt(reader, baos);
                    pdfBin = baos.toByteArray();

                    if(C_YesNoKbn.YES.eq(zokusei.getZipHozonKbn())){
                        pdfBin = BytesSerializer.zip(pBytesList.get(i));
                    } else {
                        pdfBin = pBytesList.get(i);
                    }
                } else {
                    pdfBin = pBytesList.get(i);
                    pageCount = zokusei.getPageCount();
                }

                if(C_YesNoKbn.YES.eq(zokusei.getAngoukaKbn())){
                    encryptor.setKey(serviceBean.getTyouhyouKey());
                    pdfBin = encryptor.encode(pdfBin);
                }

                AT_TyouhyouKensaku kensaku = new AT_TyouhyouKensaku();
                kensaku.setUniqueId(uniqueId);
                kensaku.setReportKey(serviceBean.getTyouhyouKey());
                kensaku.setSubSystemId(serviceBean.getSubSystemId());
                kensaku.setCategoryId(serviceBean.getCategoryId());
                kensaku.setKinouId(serviceBean.getKinouId());
                kensaku.setSyoruiCd(syoruiCdKbn);
                kensaku.setPageCount(new Integer(pageCount));
                kensaku.setFileSize(new Long(fileSize));

                if(serviceBean.getKensakuKeys() != null){

                    if (serviceBean.getKensakuKeys().length > 4) { kensaku.setKensakuKey5(serviceBean.getKensakuKeys()[4]); }
                    if (serviceBean.getKensakuKeys().length > 3) { kensaku.setKensakuKey4(serviceBean.getKensakuKeys()[3]); }
                    if (serviceBean.getKensakuKeys().length > 2) { kensaku.setKensakuKey3(serviceBean.getKensakuKeys()[2]); }
                    if (serviceBean.getKensakuKeys().length > 1) { kensaku.setKensakuKey2(serviceBean.getKensakuKeys()[1]); }
                    if (serviceBean.getKensakuKeys().length > 0) { kensaku.setKensakuKey1(serviceBean.getKensakuKeys()[0]); }
                }

                BizDate syoriYmd = serviceBean.getSyoriYmd() == null ? BizDate.getSysDate() : serviceBean.getSyoriYmd();
                kensaku.setSyoriYmd(syoriYmd);
                kensaku.setOutCount(new Integer(0));

                AT_TyouhyouHozon hozon = new AT_TyouhyouHozon();
                hozon.setReportKey(serviceBean.getTyouhyouKey());
                hozon.setPdfData(pdfBin);
                hozon.setTyouhyouJoinKey(serviceBean.getTyouhyouJoinKey());
                hozon.setAngoukaKbn(zokusei.getAngoukaKbn());
                hozon.setPdfHozonKbn(zokusei.getPdfHozonKbn());
                hozon.setZipHozonKbn(zokusei.getZipHozonKbn());

                AccessLog.Report.log(
                        "CREATE REPORT: TyouhyouKey=" + serviceBean.getTyouhyouKey(),
                        "SyoruiCds=" +  syoruiCdkbns2String(serviceBean.getSyoruiCdKbns()),
                        "KensakuKeys=" + Arrays.toString(serviceBean.getKensakuKeys())
                        );

                hozonList.add(hozon);
                kensakuList.add(kensaku);
                i++;
            }
            catch (Exception e1) {
                throw new BizAppException(e1,"EAS0008");
            }
        }
        if(commitFlg){
            ExDBTransactional.run(
                    new TransactionalCode() {
                        @Override
                        public void accept(ExDBEntityManager manager) {
                            manager.persist(kensakuList);
                            manager.persist(hozonList);
                        }
                    }
                    );
        } else {
            manager.insert(kensakuList);
            manager.insert(hozonList);
        }
    }

    static String syoruiCdkbns2String(C_SyoruiCdKbn... pSyoruiCdKbns) {

        if(pSyoruiCdKbns == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<pSyoruiCdKbns.length; i++){

            sb.append(pSyoruiCdKbns[i] + ":");
        }
        return sb.toString();
    }
}
