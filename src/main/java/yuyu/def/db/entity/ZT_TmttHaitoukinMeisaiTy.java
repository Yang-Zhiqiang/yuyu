package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.mapping.GenZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.GenQZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiTy;

/**
 * 積立配当金明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TmttHaitoukinMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_TmttHaitoukinMeisaiTy
 * @see     PKZT_TmttHaitoukinMeisaiTy
 * @see     QZT_TmttHaitoukinMeisaiTy
 * @see     GenQZT_TmttHaitoukinMeisaiTy
 */
@Entity
public class ZT_TmttHaitoukinMeisaiTy extends GenZT_TmttHaitoukinMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_TmttHaitoukinMeisaiTy() {
    }

    public ZT_TmttHaitoukinMeisaiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
