package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkIpJissekiTy;
import yuyu.def.db.mapping.GenZT_SkIpJissekiTy;
import yuyu.def.db.meta.GenQZT_SkIpJissekiTy;
import yuyu.def.db.meta.QZT_SkIpJissekiTy;

/**
 * 新契約インプット実績Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkIpJissekiTy} の JavaDoc を参照してください。
 * @see     GenZT_SkIpJissekiTy
 * @see     PKZT_SkIpJissekiTy
 * @see     QZT_SkIpJissekiTy
 * @see     GenQZT_SkIpJissekiTy
 */
@Entity
public class ZT_SkIpJissekiTy extends GenZT_SkIpJissekiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkIpJissekiTy() {
    }

    public ZT_SkIpJissekiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
