package yuyu.common.biz.bzfiledl;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.sinkeiyaku.file.csv.SkHubibunsekiLayoutFile;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * ファイルアップロードユーティリティー メソッド{@link BzFileUploadUtil#exec(C_FileSyuruiCdKbn, List<T>, boolean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFileUploadUtilExceptionTest_exec extends AbstractTest {

    @Inject
    private BzFileUploadUtil bzFileUploadUtil;

    @Inject
    private BaseDomManager manager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Test
    @TestOrder(10)
    @Transactional
    public void testExceptionExec_A1() {

        AS_FileSyurui fileSyurui = new AS_FileSyurui();
        fileSyurui.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST);
        fileSyurui.setFileSyuruiNm("新契約不備分析リスト");
        fileSyurui.setFileSyuruiKbn(C_FileSyuruiKbn.DOWNLOAD);
        fileSyurui.setDownloadFileNm("Sk_HubiBunsekiLst.csv");
        fileSyurui.setFileType("CSV");
        fileSyurui.setDataLayoutBeanClass("yuyu.def.sinkeiyaku.file.csv.SkHubibunsekiLayoutFile");
        fileSyurui.setCreateEmptyFileUmuKbn(C_UmuKbn.ARI);
        fileSyurui.setVersion(0);
        manager.insert(fileSyurui);

        changeSystemDate(BizDate.valueOf(20160106));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20160301));

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST;
        List<SkHubibunsekiLayoutFile> beanLst = Lists.newArrayList();
        SkHubibunsekiLayoutFile skTskmlistLayoutFile = new SkHubibunsekiLayoutFile();
        skTskmlistLayoutFile.setIfcDrtennmkj("代理店名");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;


        try {
            bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);
        } catch (Exception e) {
            exStringEquals(e.getMessage()
                , "ファイル操作中にエラーが発生しました。 ファイル名=Sk_HubiBunsekiLst_20160106.csv"
                , "エラーメッセージ");
        }

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());

        YuyuBizConfig.getInstance().setItijiFileHozonsaki("/WEB-INF/temp");
    }
}