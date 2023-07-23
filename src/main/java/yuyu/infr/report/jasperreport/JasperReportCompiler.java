package yuyu.infr.report.jasperreport;

import java.io.File;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.sf.jasperreports.engine.JasperCompileManager;

import org.slf4j.Logger;

import yuyu.infr.report.swakreport.config.ReportConfig;
import yuyu.infr.report.swakreport.config.ReportDetailConfig;

/**
 * JasperReport帳票レイアウトファイル(jrxmlファイル)のコンパイル処理を行います。<br />
 */
public class JasperReportCompiler {

    private final ReportDetailConfig config;

    private final String jasparRoot;

    private final String compileClasspath;

    protected static Logger logger = LoggerFactory.getLogger(JasperReportCompiler.class);

    public JasperReportCompiler() {

        config = ReportConfig.getInstance().getReportDetailConfig();
        compileClasspath = getCompileClassPath();
        jasparRoot= config.getJrxmlRootPath();

        logger.debug("◇ Jasperコンパイラ初期設定。");
        logger.debug("◇ システムプロパティに参照ライブラリパスを設定します。");
        logger.debug("   jasper.reports.compile.class.path : " + compileClasspath);
        logger.debug("   jasper.reports.compile.temp       : " + jasparRoot);
        System.setProperty("jasper.reports.compile.class.path", compileClasspath);
        System.setProperty("jasper.reports.compile.temp",       jasparRoot );

    }

    public  void compileAll() {
        compileAll(false);
    }

    public  void compileAll(boolean pForceCompileFlg) {
        compile(new File(jasparRoot), pForceCompileFlg);
    }

    public void compile(String pDirectory) {
        compile(pDirectory, false);
    }

    public void compile(String pDirectory, boolean pForceCompileFlg) {
        File file = new File(jasparRoot + pDirectory);
        compile(file,pForceCompileFlg);
    }

    private void compile(File pTargetDir, boolean pForceCompileFlg) {
        logger.debug("▼{}配下のjrxmlをコンパイルします。", pTargetDir.getName());

        int errorCount = compileJasper(pTargetDir,pForceCompileFlg);
        if (errorCount != 0) {
            throw new JasperReportServiceException("ESRP008", new Integer(errorCount));
        }

        logger.debug("▲{}配下のjrxmlをコンパイルしました。", pTargetDir.getName());
    }

    private int compileJasper(File pTargetDir, boolean pForceCompileFlg) {

        int errorCount = 0;

        File[] files = pTargetDir.listFiles();
        for (File jrxmlfile : files) {

            if(jrxmlfile.isFile() && jrxmlfile.getName().endsWith(".jrxml")){

                File jasperFile = new File(genJasperFileName(jrxmlfile.getAbsolutePath()));

                boolean compileFlg = needCompile(pForceCompileFlg, jrxmlfile, jasperFile);
                if (compileFlg) {
                    try {
                        JasperCompileManager.compileReportToFile(jrxmlfile.getAbsolutePath(), jasperFile.getAbsolutePath());
                        logger.debug("││ compile:success  [{}]",jasperFile.getName());
                    } catch (Throwable e) {
                        errorCount++;
                        logger.error("││!compile:fail     [{}]",jasperFile.getName(),e);
                        logger.error("││!compile:fail     "+ jasperFile.getName(),e);
                    }
                } else {
                    logger.debug("││ already compiled [{}]",jasperFile.getName());
                }
            }
            else if(jrxmlfile.isDirectory() && !jrxmlfile.isHidden()){
                int cnt = compileJasper(jrxmlfile,pForceCompileFlg);
                errorCount = errorCount + cnt;
            }
        }

        return errorCount;
    }

    private static boolean needCompile(boolean pForceCompileFlg, File jrxmlfile, File jasperFile) {
        boolean compileFlg;
        if (pForceCompileFlg) {

            compileFlg = true;

        } else {
            long lSourceTimeStamp = jrxmlfile.lastModified();
            long lTargetTimeStamp = jasperFile.lastModified();

            if ((lSourceTimeStamp == 0) || (lSourceTimeStamp > lTargetTimeStamp)) {
                compileFlg = true;
            } else {
                compileFlg = false;
            }
        }
        return compileFlg;
    }

    private static String genJasperFileName(String pFileName) {

        int lastIndex   = pFileName.lastIndexOf(".");
        String jasperFileName  = pFileName.substring(0, lastIndex);
        return jasperFileName + ".jasper";
    }

    private String getCompileClassPath() {

        StringBuffer path      = new StringBuffer();
        String       separator = System.getProperty("path.separator");

        path.append(config.getJasperConfig().getCompileClassPath() + separator);

        return path.toString();
    }

}
