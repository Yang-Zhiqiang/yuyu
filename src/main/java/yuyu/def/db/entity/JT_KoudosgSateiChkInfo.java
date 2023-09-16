package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_KoudosgSateiChkInfo;


/**
 * 高度障害査定チェック情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_KoudosgSateiChkInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_KoudosgSateiChkInfo<br />
 * @see     PKJT_KoudosgSateiChkInfo<br />
 * @see     QJT_KoudosgSateiChkInfo<br />
 * @see     GenQJT_KoudosgSateiChkInfo<br />
 */
@Entity
public class JT_KoudosgSateiChkInfo extends GenJT_KoudosgSateiChkInfo {

    private static final long serialVersionUID = 1L;

    public JT_KoudosgSateiChkInfo() {
    }

    public JT_KoudosgSateiChkInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_KoudosgSateiChkInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgSateiChkInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgSateiChkInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

