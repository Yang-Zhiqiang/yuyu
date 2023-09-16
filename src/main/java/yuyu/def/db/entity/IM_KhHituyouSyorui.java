package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIM_KhHituyouSyorui;


/**
 * 契約保全必要書類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhHituyouSyorui} の JavaDoc を参照してください。<br />
 * @see     GenIM_KhHituyouSyorui<br />
 * @see     PKIM_KhHituyouSyorui<br />
 * @see     QIM_KhHituyouSyorui<br />
 * @see     GenQIM_KhHituyouSyorui<br />
 */
@Entity
public class IM_KhHituyouSyorui extends GenIM_KhHituyouSyorui {

    private static final long serialVersionUID = 1L;

    public IM_KhHituyouSyorui() {
    }

    public IM_KhHituyouSyorui(String pKinouId,Integer pHanteikbn1,Integer pHanteikbn2,Integer pHanteikbn3,Integer pHtysrirenno) {
        super(pKinouId,pHanteikbn1,pHanteikbn2,pHanteikbn3,pHtysrirenno);
    }



}

