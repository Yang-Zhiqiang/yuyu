CREATE TABLE IT_BAK_KhSisuurendoTmttkn (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     tmttkntaisyouym                                    VARCHAR     (6)                                                       NOT NULL  ,  /* 積立金対象年月 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     tmttknkouryokukaisiymd                             VARCHAR     (8)                                                                 ,  /* 積立金効力開始日 */
     teiritutmttkngk                                    NUMBER      (13)                                                                ,  /* 定率積立金額 */
     teiritutmttkngk$                                   VARCHAR     (10)                                                                ,  /* 定率積立金額(通貨型) */
     sisuurendoutmttkngk                                NUMBER      (13)                                                                ,  /* 指数連動積立金額 */
     sisuurendoutmttkngk$                               VARCHAR     (10)                                                                ,  /* 指数連動積立金額(通貨型) */
     sisuuupritu                                        NUMBER      (5,4)                                                               ,  /* 指数上昇率 */
     tmttknzoukaritu                                    NUMBER      (5,4)                                                               ,  /* 積立金増加率 */
     tmttknhaneitmmshanteiymd                           VARCHAR     (8)                                                                 ,  /* 積立金反映時積増判定日 */
     tmttknhaneisisuu                                   NUMBER      (10,5)                                                              ,  /* 積立金反映時指数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     itenmaeteiritutmttkngk                             NUMBER      (13)                                                                ,  /* 移転前定率積立金額 */
     itenmaeteiritutmttkngk$                            VARCHAR     (10)                                                                ,  /* 移転前定率積立金額(通貨型) */
     itenmaesisuurendoutmttkngk                         NUMBER      (13)                                                                ,  /* 移転前指数連動積立金額 */
     itenmaesisuurendoutmttkngk$                        VARCHAR     (10)                                                                   /* 移転前指数連動積立金額(通貨型) */
)
;

ALTER TABLE IT_BAK_KhSisuurendoTmttkn ADD CONSTRAINT PK_BAK_KhSisuurendoTmttkn PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     tmttkntaisyouym                                          , /* 積立金対象年月 */
     renno                                                      /* 連番 */
) ;
