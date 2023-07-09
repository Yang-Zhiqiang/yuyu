CREATE TABLE IT_BAK_SyuunouHenknRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号 */
     denkihyouymd                                       VARCHAR     (8)                                                                 ,  /* 伝票起票日 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     hnkngk                                             NUMBER      (13)                                                                ,  /* 返金額 */
     hnkngk$                                            VARCHAR     (10)                                                                ,  /* 返金額(通貨型) */
     shrriyuukbn                                        VARCHAR     (2)                                                                 ,  /* 支払理由区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     creditkessaiyouno                                  VARCHAR     (26)                                                                   /* クレジットカード決済用番号 */
)
;

ALTER TABLE IT_BAK_SyuunouHenknRireki ADD CONSTRAINT PK_BAK_SyuunouHenknRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;
