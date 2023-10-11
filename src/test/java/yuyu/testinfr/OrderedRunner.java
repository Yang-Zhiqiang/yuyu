package yuyu.testinfr;

import java.util.List;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import com.google.common.collect.Ordering;

/**
 * テストメソッドの実行順序を任意に設定可能なテストランナーです。<br />
 * 実行順序はテストメソッドに「&#64;{@link TestOrder}(実行順)」というアノテーションを付加することで指定します。
 */
public class OrderedRunner extends SWAKTestRunner {

    public OrderedRunner(Class<?> pClass) throws InitializationError {
        super(pClass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        return new Ordering<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod f1, FrameworkMethod f2) {
                TestOrder o1 = f1.getAnnotation(TestOrder.class);
                TestOrder o2 = f2.getAnnotation(TestOrder.class);
                if      (o1 == null && o2 == null) return  0;
                else if (o1 == null)               return -1;
                else if (o2 == null)               return  1;
                return o1.value() - o2.value();
            }
        }.immutableSortedCopy(super.computeTestMethods());
    }
}
