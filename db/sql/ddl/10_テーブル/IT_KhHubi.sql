CREATE TABLE IT_KhHubi (
     hubisikibetukey                                    VARCHAR     (20)                                                      NOT NULL  ,  /* 不備識別キー                                        */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号                                          */
     jimuttdknm                                         VARCHAR     (20)                                                                ,  /* 契約管理事務手続名                                     */
     renrakusakinmkj                                    VARCHAR     (15)                                                                ,  /* 連絡先氏名（漢字）                                     */
     renrakuyno                                         VARCHAR     (7)                                                                 ,  /* 連絡先郵便番号                                       */
     renrakusakiadr1kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所１（漢字）                                    */
     renrakusakiadr2kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所２（漢字）                                    */
     renrakusakiadr3kj                                  VARCHAR     (30)                                                                ,  /* 連絡先住所３（漢字）                                    */
     renrakusakitelno                                   VARCHAR     (14)                                                                ,  /* 連絡先電話番号                                       */
     renrakuarea                                        VARCHAR     (418)                                                               ,  /* 連絡欄                                           */
     hubianswerkjt                                      VARCHAR     (8)                                                                 ,  /* 不備回答期日                                        */
     sksreadymd                                         VARCHAR     (8)                                                                 ,  /* 請求書読込日                                        */
     hassinsakifsthubihasinymd1                         VARCHAR     (8)                                                                 ,  /* 発信先別初回不備発信日１                                  */
     hassinsakifsthubihasinymd2                         VARCHAR     (8)                                                                 ,  /* 発信先別初回不備発信日２                                  */
     hassinsakikaisuu1                                  NUMBER      (2)                                                                 ,  /* 発信先別発信回数１                                     */
     hassinsakikaisuu2                                  NUMBER      (2)                                                                 ,  /* 発信先別発信回数２                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_KhHubi ADD CONSTRAINT PK_KhHubi PRIMARY KEY (
     hubisikibetukey                                            /* 不備識別キー                                         */
) ;
