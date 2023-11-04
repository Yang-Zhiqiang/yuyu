package yuyu.def.db.entity;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.runner.RunWith;

/**
 * エンティティ単位の共通テストクラスの抽象クラスです。<br />
 * テストクラスはこのクラスを継承して定義されたテストメソッドを実装して下さい。<br />
 * 各テストメソッドで、想定通りの結果が得られた場合には{@see org.junit.Assert}クラスをメソッドに「true」を<br /><br />
 * それ以外の場合は「false」を設定します。<br />
 */
@RunWith(SWAKTestRunner.class)
public abstract class AbstractEntityTest implements EntityTestInterface {

    public static void insertTestData() {
    }

    public static void deleteTestData() {
    }
}
