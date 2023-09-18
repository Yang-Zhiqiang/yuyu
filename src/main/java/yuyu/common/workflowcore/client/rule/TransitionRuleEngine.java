package yuyu.common.workflowcore.client.rule;

import java.lang.reflect.Method;

import yuyu.common.workflowcore.client.util.WorkflowClientUtils;

/**
 * 遷移先決定に使用するルールエンジンです。
 * <pre>
 *
 * 【使用例１】
 *  {@code
 *       // inBean編集
 *       inBean  = new InBean();
 *       OutBaen out = new OutBaen();
 *
 *       TransitionRuleEngine<OutBaen> ruleEngine = TransitionRuleEngine.newInstance("NyuukinForwardRule");
 *       ruleEngine.apply(inBean, out);
 *  }
 * </pre>
 */
public class TransitionRuleEngine<T> extends AbstractRuleEngine<Object, T>{

    private String ruleName_;
    private TransitionRuleEngine(String ruleName){
        this.ruleName_ =   ruleName;
    }
    public static <O> TransitionRuleEngine<O> newInstance(String ruleName, Class<O> ... clazz){
        return new TransitionRuleEngine<O>(ruleName);
    }
    @Override
    public String getRuleName() {
        return this.ruleName_;
    }

    @Override
    public String getLogFilename() throws Exception {
        String className  = RuleConfig.getProperty("iwf.client.rule.logfile.class");
        String methodName = RuleConfig.getProperty("iwf.client.rule.logfile.method");

        @SuppressWarnings("rawtypes")
        Class clazz = WorkflowClientUtils.getClassForName(className);
        Method method = WorkflowClientUtils.getMethodForName(clazz, methodName);

        return (String)method.invoke(clazz.newInstance(), new Object[0]);
    }

    @Override
    public String getResultField() {
        return RuleConfig.getProperty("iwf.client.result.field");
    }

}
