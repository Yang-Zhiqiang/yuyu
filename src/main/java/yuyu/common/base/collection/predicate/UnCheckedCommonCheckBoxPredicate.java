package yuyu.common.base.collection.predicate;

import jp.co.slcs.swak.util.reflect.ReflectUtil;
import yuyu.common.base.collection.interfaces.HasCommonCheckBox;

import com.google.common.base.Predicate;

/**
 * 汎用チェックボックス（CommonCheckBox）を要素に持つビーンを要素とする<br />
 * リストの中から、このチェックがFalseであるビーンを抽出するための Predicate クラスです。<br />
 * 要素に汎用チェックボックスが含まれない場合は例外がスローされます。
 */
public class UnCheckedCommonCheckBoxPredicate implements Predicate<Object> {

    @Override
    public boolean apply(Object pObject) {

        HasCommonCheckBox bean = ReflectUtil.forceCast(pObject, HasCommonCheckBox.class);

        return !bean.getCommonCheckBox();
    }
}
