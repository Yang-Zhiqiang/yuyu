package yuyu.batch.siharai.simaster.sibyoumeitorikomi;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzcommon.SkjStringUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.siharai.file.fixedlength.SiAiKyuubuByoumeiFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

/**
 * 連携用F（（支払）あいキューブ病名マスタ送信ファイル）を読み込み、病名マスタに反映するクラス
 */
public class SiByoumeiTorikomiBatch implements Batch {

    private final String FILE_NAME = "RAZ4IA01ZYYYYMMDD00001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiByoumeiTorikomiDao siByoumeiTorikomiDao;

    Long syoriKensu;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() throws Exception {

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);
        syoriKensu = (long) 0;

        String batchInputDir = YuyuBaseConfig.getInstance().getBatchInputDir();
        String filePath = batchInputDir + "/" + FILE_NAME;
        boolean existFlg = false;
        existFlg = fileControlManager.isExistFile(filePath);

        if (existFlg) {

            try (FileEntityReader<SiAiKyuubuByoumeiFile> siAiKyuubuByoumeiFileEntityReader = fileControlManager
                .getFileEntityReader(
                    filePath, SiAiKyuubuByoumeiFile.class, FileType.FIXEDLENGTH)) {

                if (!siAiKyuubuByoumeiFileEntityReader.hasNext()) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EAS0024, FILE_NAME));

                }

                deleteByoumeiData();

                while (siAiKyuubuByoumeiFileEntityReader.hasNext()) {

                    try (EntityInserter<JM_Byoumei> entityInserter = new EntityInserter<>();) {
                        SiAiKyuubuByoumeiFile siAiKyuubuByoumeiFileEntity = siAiKyuubuByoumeiFileEntityReader.next();

                        JM_Byoumei jmByoumei = null;
                        jmByoumei = createByoumeiData(siAiKyuubuByoumeiFileEntity);

                        BizPropertyInitializer.initialize(jmByoumei);

                        entityInserter.add(jmByoumei);

                        syoriKensu++;

                    }

                }

            } catch (IOException e) {

                throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0027));

            } finally {

                fileControlManager.remove(filePath);
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
            }
        } else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0018, FILE_NAME));
        }

    }

    private void deleteByoumeiData() {

        siByoumeiTorikomiDao.deleteByoumei();
    }

    private JM_Byoumei createByoumeiData(SiAiKyuubuByoumeiFile pSiAiKyuubuByoumeiFile) {

        JM_Byoumei jmByoumei = new JM_Byoumei();

        String byoumeizenkaku = pSiAiKyuubuByoumeiFile.getIffByoumeizenkaku();

        if (!BizUtil.isBlank(byoumeizenkaku)) {
            byoumeizenkaku = SkjStringUtil.convInvalidChar(byoumeizenkaku);
        }

        SiByoumeiHnknBean siByoumeiHnknBean = SWAKInjector.getInstance(SiByoumeiHnknBean.class);
        siByoumeiHnknBean.setByoumeiknkensakuHnkn(pSiAiKyuubuByoumeiFile.getIffByoumeihuriganakensaku());

        RayConvertUtil.toValidString(siByoumeiHnknBean);

        jmByoumei.setByoumeitourokuno(pSiAiKyuubuByoumeiFile.getIffByoumeitourokuno());
        jmByoumei.setByoumeikj(byoumeizenkaku);
        jmByoumei.setByoumeizenkaku(byoumeizenkaku);
        jmByoumei.setByoumeikn(siByoumeiHnknBean.getByoumeiknkensakuHnkn());
        jmByoumei.setByoumeiknkensaku(siByoumeiHnknBean.getByoumeiknkensakuHnkn());
        jmByoumei.setByoumeicd(pSiAiKyuubuByoumeiFile.getIffByoumeicd());
        jmByoumei.setGaitoukbn1(pSiAiKyuubuByoumeiFile.getIffGaitoukbn1());
        jmByoumei.setGaitoukbn2(C_ByoumeiGaitouKbn2.valueOf(pSiAiKyuubuByoumeiFile.getIffGaitoukbn2()));
        jmByoumei.setGaitoukbn3(pSiAiKyuubuByoumeiFile.getIffGaitoukbn3());
        jmByoumei.setGaitoukbn4(pSiAiKyuubuByoumeiFile.getIffGaitoukbn4());
        jmByoumei.setGaitoukbn5(pSiAiKyuubuByoumeiFile.getIffGaitoukbn5());
        jmByoumei.setTyuuimongon(pSiAiKyuubuByoumeiFile.getIffTyuuimongon());

        return jmByoumei;
    }

}
