CREATE TABLE BM_RateW (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* レート用通貨種類区分 */
     ratedai1hknkkn                                     CHAR        (2)                                                       NOT NULL  ,  /* レート用第１保険期間 */
     wrate00                                            NUMBER      (9,6)                                                               ,  /* Ｗレート００ */
     wrate01                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０１ */
     wrate02                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０２ */
     wrate03                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０３ */
     wrate04                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０４ */
     wrate05                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０５ */
     wrate06                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０６ */
     wrate07                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０７ */
     wrate08                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０８ */
     wrate09                                            NUMBER      (9,6)                                                               ,  /* Ｗレート０９ */
     wrate10                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１０ */
     wrate11                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１１ */
     wrate12                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１２ */
     wrate13                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１３ */
     wrate14                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１４ */
     wrate15                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１５ */
     wrate16                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１６ */
     wrate17                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１７ */
     wrate18                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１８ */
     wrate19                                            NUMBER      (9,6)                                                               ,  /* Ｗレート１９ */
     wrate20                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２０ */
     wrate21                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２１ */
     wrate22                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２２ */
     wrate23                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２３ */
     wrate24                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２４ */
     wrate25                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２５ */
     wrate26                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２６ */
     wrate27                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２７ */
     wrate28                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２８ */
     wrate29                                            NUMBER      (9,6)                                                               ,  /* Ｗレート２９ */
     wrate30                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３０ */
     wrate31                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３１ */
     wrate32                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３２ */
     wrate33                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３３ */
     wrate34                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３４ */
     wrate35                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３５ */
     wrate36                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３６ */
     wrate37                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３７ */
     wrate38                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３８ */
     wrate39                                            NUMBER      (9,6)                                                               ,  /* Ｗレート３９ */
     wrate40                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４０ */
     wrate41                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４１ */
     wrate42                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４２ */
     wrate43                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４３ */
     wrate44                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４４ */
     wrate45                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４５ */
     wrate46                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４６ */
     wrate47                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４７ */
     wrate48                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４８ */
     wrate49                                            NUMBER      (9,6)                                                               ,  /* Ｗレート４９ */
     wrate50                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５０ */
     wrate51                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５１ */
     wrate52                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５２ */
     wrate53                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５３ */
     wrate54                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５４ */
     wrate55                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５５ */
     wrate56                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５６ */
     wrate57                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５７ */
     wrate58                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５８ */
     wrate59                                            NUMBER      (9,6)                                                               ,  /* Ｗレート５９ */
     wrate60                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６０ */
     wrate61                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６１ */
     wrate62                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６２ */
     wrate63                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６３ */
     wrate64                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６４ */
     wrate65                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６５ */
     wrate66                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６６ */
     wrate67                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６７ */
     wrate68                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６８ */
     wrate69                                            NUMBER      (9,6)                                                               ,  /* Ｗレート６９ */
     wrate70                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７０ */
     wrate71                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７１ */
     wrate72                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７２ */
     wrate73                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７３ */
     wrate74                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７４ */
     wrate75                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７５ */
     wrate76                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７６ */
     wrate77                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７７ */
     wrate78                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７８ */
     wrate79                                            NUMBER      (9,6)                                                               ,  /* Ｗレート７９ */
     wrate80                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８０ */
     wrate81                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８１ */
     wrate82                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８２ */
     wrate83                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８３ */
     wrate84                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８４ */
     wrate85                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８５ */
     wrate86                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８６ */
     wrate87                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８７ */
     wrate88                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８８ */
     wrate89                                            NUMBER      (9,6)                                                               ,  /* Ｗレート８９ */
     wrate90                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９０ */
     wrate91                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９１ */
     wrate92                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９２ */
     wrate93                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９３ */
     wrate94                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９４ */
     wrate95                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９５ */
     wrate96                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９６ */
     wrate97                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９７ */
     wrate98                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９８ */
     wrate99                                            NUMBER      (9,6)                                                               ,  /* Ｗレート９９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_RateW ADD CONSTRAINT PK_RateW PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                                    , /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                          , /* レート用通貨種類区分 */
     ratedai1hknkkn                                             /* レート用第１保険期間 */
) ;
