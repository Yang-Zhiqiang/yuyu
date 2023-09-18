package yuyu.common.workflowcore.client.rule.holder;

import static org.apache.commons.io.FilenameUtils.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.rule.builder.dialect.java.JavaDialectConfiguration;
import org.slf4j.Logger;

import yuyu.common.workflowcore.client.rule.RuleConfig;
import yuyu.common.workflowcore.client.util.WorkflowClientUtils;

/**
 * ルールエンジンで使用するナレッジベースを保持・管理するクラスです。
 * <pre>
 *  {@link KnowledgeBaseHolder#getInstance()}を使用し、当クラスのインスタンスを取得します。
 *  {@link KnowledgeBaseHolder#set(String, KnowledgeBase)}を使用し、コンディションBeanを設定します。
 *  {@link KnowledgeBaseHolder#get(String)}を使用し、コンディションBeanを取得します。
 *
 * 【使用例】
 *  {@code
 *  // ホルダー取得
 *  KnowledgeBaseHolder holder = KnowledgeBaseHolder.getInstance();
 *
 *  // 存在しない場合、登録
 *  if(!holder.exists("NyuukinForwardRule")){
 *      holder.set("NyuukinForwardRule", KnowledgeBaseHolder.readKnowledgeBase("NyuukinForwardRule));
 *  }
 *
 *  // 存在する場合、ナレッジベースの取得
 *  if(holder.exists("NyuukinForwardRule")){
 *      KnowledgeBase bean = holder.get("NyuukinForwardRule");
 *  }
 * </pre>
 */
public class KnowledgeBaseHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(KnowledgeBaseHolder.class);

    private static final KnowledgeBaseHolder instance = new KnowledgeBaseHolder();

    private Map<String, KnowledgeBase> knowledgeBaseMap = new HashMap<String, KnowledgeBase>();

    private boolean isInitialized = false;

    private static String getRuleDirPath() throws Exception {
        String className = RuleConfig.getProperty("iwf.client.rule.dir.class");
        String methodName = RuleConfig.getProperty("iwf.client.rule.dir.method");

        @SuppressWarnings("rawtypes")
        Class clazz   = WorkflowClientUtils.getClassForName(className);
        Method method = WorkflowClientUtils.getMethodForName(clazz, methodName);

        return (String)method.invoke(clazz.newInstance(), new Object[0]);
    }

    static final String EXTENSION    = ".xls";

    private KnowledgeBaseHolder(){
    }

    private void init() {
        try {
            LOGGER.debug("KnowledgeBaseHolderインスタンスの初期化を開始します。");
            String path = getRuleDirPath();
            File file = new File(path);

            if(StringUtils.isEmpty(path)) {
                LOGGER.error("ファイルパスが取得できませんでした。");
            }

            if(!file.isDirectory()){
                LOGGER.error("ディレクトリではありません。[path=" + file.getAbsoluteFile() + "]");
                throw new RuntimeException("ディレクトリではありません。[path=" + file.getAbsoluteFile() + "]");
            }
            if(!file.exists()){
                LOGGER.error("パスは存在しません。[path=" + file.getAbsoluteFile() + "]");
                throw new RuntimeException("パスは存在しません。[path=" + file.getAbsoluteFile() + "]");
            }
            LOGGER.debug("ルールファイルディレクトリを取得しました。[path=" + file.getAbsoluteFile() + "]");

            @SuppressWarnings("unchecked")
            Collection<File> ruleFiles = FileUtils.listFiles(
                file, new String[]{"xls"}, false);

            if(ruleFiles == null || ruleFiles.isEmpty()){
                LOGGER.debug("ルールファイルが存在しません。[path=" + file.getAbsoluteFile() + "]");
                throw new RuntimeException("ルールファイルが存在しません。[path=" + file.getAbsoluteFile() + "]");
            }

            for(File ruleFile : ruleFiles){
                String ruleName = getBaseName(ruleFile.getAbsolutePath());
                set(ruleName, null);
            }
            LOGGER.debug("ルールファイルディレクトリ内の全てのファイルを読み込みました。");

            isInitialized = true;
        } catch (Exception e) {
            LOGGER.error("KnowledgeBaseHolderインスタンスの初期化中にエラーが発生しました。", e);
        }
    }

    public static KnowledgeBaseHolder getInstance(){

        if (!instance.isInitialized) {
            synchronized (KnowledgeBaseHolder.class) {
                if (!instance.isInitialized) {
                    instance.init();
                }
            }
        }
        return instance;
    }

    public boolean exists(String ruleName){
        return knowledgeBaseMap.containsKey(ruleName);
    }

    synchronized public KnowledgeBase get(String ruleName){
        KnowledgeBase kbase = knowledgeBaseMap.get(ruleName);
        if(kbase == null){
            kbase = readKnowledgeBase(ruleName);
            updateKnowledgeBase(ruleName, kbase);
        }
        return kbase;
    }
    synchronized public void set(String ruleName, KnowledgeBase knowledgeBase){

        if(!knowledgeBaseMap.containsKey(ruleName)){
            try {
                knowledgeBaseMap.put(ruleName, knowledgeBase);
            } catch (Exception e) {
                LOGGER.error("ナレッジベースの初期設定に失敗しました。");
                throw new RuntimeException("ナレッジベースの初期設定に失敗しました。", e);
            }
            LOGGER.debug("ナレッジベースを設定しました。[ruleName=" + ruleName + "]");
        }
    }
    synchronized public void updateKnowledgeBase(String ruleName, KnowledgeBase knowledgeBase){
        if(knowledgeBaseMap.containsKey(ruleName)){
            try {
                knowledgeBaseMap.put(ruleName, knowledgeBase);
            } catch (Exception e) {
                LOGGER.error("ナレッジベースの初期設定に失敗しました。");
                throw new RuntimeException("ナレッジベースの初期設定に失敗しました。", e);
            }
            LOGGER.debug("ナレッジベースを更新しました。[ruleName=" + ruleName + "]");
        }
    }
    @Deprecated
    public synchronized void readAllKnowledgeBase() {
        Set<String> keySet = knowledgeBaseMap.keySet();
        for (String key : keySet) {
            updateKnowledgeBase(key, readKnowledgeBase(key));
        }
    }

    private static KnowledgeBase readKnowledgeBase(String ruleName) {

        try {
            LOGGER.debug("ナレッジベースの読み込みを開始します。[ruleName=" + ruleName + "]");
            String path = getRuleDirPath();
            KnowledgeBuilderConfiguration kbconfig = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
            kbconfig.setProperty(JavaDialectConfiguration.JAVA_COMPILER_PROPERTY, "JANINO");
            kbconfig.setProperty("drools.dialect.java.compiler.lnglevel", "1.7");
            LOGGER.debug("KnowledgeBuilderConfigurationの設定を完了しました。");

            KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(kbconfig);

            DecisionTableConfiguration config = KnowledgeBuilderFactory.newDecisionTableConfiguration();
            config.setInputType(DecisionTableInputType.XLS);
            LOGGER.debug("DecisionTableConfigurationの設定を完了しました。");

            Resource resource = null;
            String ruleFileName = path + ruleName + EXTENSION;
            if(new File(ruleFileName).exists()){
                LOGGER.debug("絶対パスでリソースを登録します。[file=" + ruleFileName + "]");
                resource = ResourceFactory.newFileResource(ruleFileName);
            }else{
                LOGGER.debug("相対パスでリソースを登録します。[file=" + ruleFileName + "]");
                resource = ResourceFactory.newClassPathResource(ruleFileName, KnowledgeBase.class.getClassLoader());
            }

            try {
                kbuilder.add(resource, ResourceType.DTABLE, config);
            } catch (Exception e) {
                LOGGER.error("ナレッジビルダーへのリソース登録に失敗しました。[file=" + ruleFileName + "]", e);
            }
            KnowledgeBuilderErrors errors = kbuilder.getErrors();
            if (errors.size() > 0) {
                for (KnowledgeBuilderError error : errors) {
                    LOGGER.error("リソース登録中にエラーを発見しました。[message : " + error.getMessage() + "]");
                }
                throw new IllegalArgumentException("Could not resist knowledge.");
            }

            KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
            kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
            LOGGER.debug("ナレッジベースの生成を完了しました。[ruleName=" + ruleName + "]");
            return kbase;
        } catch (Exception e) {
            throw new RuntimeException("readKnowledgeBase()実行中にエラーが発生しました", e);
        }
    }
}
