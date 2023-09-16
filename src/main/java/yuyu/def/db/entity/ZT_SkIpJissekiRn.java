package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkIpJissekiRn;
import yuyu.def.db.mapping.GenZT_SkIpJissekiRn;
import yuyu.def.db.meta.GenQZT_SkIpJissekiRn;
import yuyu.def.db.meta.QZT_SkIpJissekiRn;

/**
 * 新契約インプット実績Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkIpJissekiRn} の JavaDoc を参照してください。
 * @see     GenZT_SkIpJissekiRn
 * @see     PKZT_SkIpJissekiRn
 * @see     QZT_SkIpJissekiRn
 * @see     GenQZT_SkIpJissekiRn
 */
@Entity
public class ZT_SkIpJissekiRn extends GenZT_SkIpJissekiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkIpJissekiRn() {
    }

    public ZT_SkIpJissekiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
