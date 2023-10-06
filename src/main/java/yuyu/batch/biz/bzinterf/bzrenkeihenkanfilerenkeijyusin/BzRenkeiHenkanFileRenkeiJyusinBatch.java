package yuyu.batch.biz.bzinterf.bzrenkeihenkanfilerenkeijyusin;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェース 連携項目変換処理（ファイル連携方式受信）クラス
 */
public class BzRenkeiHenkanFileRenkeiJyusinBatch<T1, T2 extends AbstractExDBEntity<T2, ?>> implements Batch {

    public final String INTERFACEID = "インターフェースＩＤ";

    public final String SYORIHOUSIKI = "処理方式";

    public final String HENKANHOUKOU = "変換方向";

    public final String HENKANMAELAYOUTNAME = "変換前レイアウト名";

    public final String HENKANGOLAYOUTNAME = "変換後レイアウト名";

    public final String RENKEIFILENM = "連携ファイル名";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRenkeiHenkanFileRenkeiJyusinBatchParam bzRenkeiHenkanFileRenkeiJyusinBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRenkeiHenkanFileRenkeiJyusinDao bzRenkeiHenkanFileRenkeiJyusinDao;

    @Override
    public BatchParam getParam() {

        return bzRenkeiHenkanFileRenkeiJyusinBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        if (BizUtil.isBlank(bzRenkeiHenkanFileRenkeiJyusinBatchParam.getInterfaceId())) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0010, "interfaceId"));
        }

        BT_SystemRenkei systemRenkei = bizDomManager.getSystemRenkei(
            bzRenkeiHenkanFileRenkeiJyusinBatchParam.getInterfaceId());

        if (systemRenkei == null) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0010, "interfaceId"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, INTERFACEID,
            systemRenkei.getInterfaceid()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, SYORIHOUSIKI,
            systemRenkei.getSyorihousiki().getValue()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANHOUKOU,
            systemRenkei.getHenkanhoukou().getValue()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANMAELAYOUTNAME,
            systemRenkei.getHenkanmaelayoutname()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANGOLAYOUTNAME,
            systemRenkei.getHenkangolayoutname()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, RENKEIFILENM,
            systemRenkei.getRenkeifilenm()));

        bzRenkeiHenkanFileRenkeiJyusinDao.deleteByTableid(systemRenkei.getHenkangolayoutid());

        String renkeiFilediRectory = systemRenkei.getRenkeifiledirectory() + "/" + systemRenkei.getRenkeifilenm();

        try {
            @SuppressWarnings("resource")
            InputStream inputStream = null;
            @SuppressWarnings("resource")
            FileEntityReader<T1> fileEntityReader = null;

            long recordmaekensu = 0;

            try {
                inputStream = new FileInputStream(renkeiFilediRectory);

                FileEntityManager fileEntityManager;
                if (C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH.eq(systemRenkei.getRenkeifiletype()) ||
                    C_SystemRenkeiFileSyubetuKbn.CSV_FIXEDLENGTH.eq(systemRenkei.getRenkeifiletype())) {

                    fileEntityManager = FileEntityManagerFactory.getDefaultFactory().
                        createFileEntityManager(FileType.CSV);
                }
                else if (C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH.eq(systemRenkei.getRenkeifiletype())) {

                    fileEntityManager = FileEntityManagerFactory.getDefaultFactory().
                        createFileEntityManager(FileType.FIXEDLENGTH);
                }
                else {

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EAC0046, "連携ファイル種別"));
                }

                String filedEntityPath = YuyuBizConfig.getInstance().getTeigiInfoKakunouRootPass() +
                    systemRenkei.getSubSystemId() + ".file.zdb." + systemRenkei.getHenkanmaelayoutid();

                @SuppressWarnings("unchecked")
                Class<T1> systemRenkeiClass = (Class<T1>) Class.forName(filedEntityPath);
                fileEntityReader = fileEntityManager.getFileEntityReader(systemRenkeiClass, inputStream);

                String tableEntityPath =
                    YuyuBizConfig.getInstance().getTableTeigiInfoKakunouPass() + systemRenkei.getHenkangolayoutid();

                @SuppressWarnings("unchecked")
                Class<T2> systemRenkeiClassgo = (Class<T2>) Class.forName(tableEntityPath);

                try (EntityInserter<T2> systemRenkeiInserter = new EntityInserter<>()) {
                    BzRenkeiHenkanUtil<T1, T2> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<T1, T2>();

                    bzRenkeiHenkanUtil.initialize(systemRenkeiClass,
                        systemRenkeiClassgo,
                        systemRenkei.getSyorihousiki(),
                        systemRenkei.getHenkanhoukou(),
                        systemRenkei.getRenkeifiletype());

                    while (fileEntityReader.hasNext()) {

                        recordmaekensu++;

                        T1 systemRenkeidatamae = fileEntityReader.next();

                        T2 systemRenkeidatago = bzRenkeiHenkanUtil.convBean(systemRenkeidatamae);
                        systemRenkeiInserter.add(systemRenkeidatago);
                    }
                }

                long recordgoukensu = bzRenkeiHenkanFileRenkeiJyusinDao.getCountByTableid(
                    systemRenkei.getHenkangolayoutid());

                if (recordmaekensu == recordgoukensu) {

                    batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(recordgoukensu)));
                }
                else {

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EBF1003,
                        systemRenkei.getHenkanmaelayoutname(),
                        String.valueOf(recordmaekensu),
                        systemRenkei.getHenkangolayoutid(),
                        String.valueOf(recordgoukensu)));
                }

            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileEntityReader != null) {
                    fileEntityReader.close();
                }
            }
        } catch (Throwable t) {
            if (t instanceof BizAppException) {
                throw (BizAppException) t;
            }
            throw new CommonBizAppException(t, t.getClass().getSimpleName());
        }
    }
}
