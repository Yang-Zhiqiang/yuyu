package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_MisyuupMkkpDetail;


/**
 * 未収Ｐ未経過Ｐ明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_MisyuupMkkpDetail} の JavaDoc を参照してください。<br />
 * @see     GenJT_MisyuupMkkpDetail<br />
 * @see     PKJT_MisyuupMkkpDetail<br />
 * @see     QJT_MisyuupMkkpDetail<br />
 * @see     GenQJT_MisyuupMkkpDetail<br />
 */
@Entity
public class JT_MisyuupMkkpDetail extends GenJT_MisyuupMkkpDetail {

    private static final long serialVersionUID = 1L;

    public JT_MisyuupMkkpDetail() {
    }

    public JT_MisyuupMkkpDetail(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pDatarenno) {
        super(pSkno,pSyono,pSeikyuurirekino,pDatarenno);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_MisyuupMkkpDetail.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_MisyuupMkkpDetail.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_MisyuupMkkpDetail.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

