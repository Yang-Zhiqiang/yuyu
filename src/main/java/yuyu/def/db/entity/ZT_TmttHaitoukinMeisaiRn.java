package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.mapping.GenZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.GenQZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiRn;

/**
 * 積立配当金明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TmttHaitoukinMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_TmttHaitoukinMeisaiRn
 * @see     PKZT_TmttHaitoukinMeisaiRn
 * @see     QZT_TmttHaitoukinMeisaiRn
 * @see     GenQZT_TmttHaitoukinMeisaiRn
 */
@Entity
public class ZT_TmttHaitoukinMeisaiRn extends GenZT_TmttHaitoukinMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_TmttHaitoukinMeisaiRn() {
    }

    public ZT_TmttHaitoukinMeisaiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
