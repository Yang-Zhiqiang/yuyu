package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.mapping.GenBM_RateD;
import yuyu.def.db.meta.GenQBM_RateD;
import yuyu.def.db.meta.QBM_RateD;

/**
 * Ｄレートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateD}</td><td colspan="3">Ｄレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>drate00</td><td>Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate01</td><td>Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate02</td><td>Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate03</td><td>Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate04</td><td>Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate05</td><td>Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate06</td><td>Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate07</td><td>Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate08</td><td>Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate09</td><td>Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate10</td><td>Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate11</td><td>Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate12</td><td>Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate13</td><td>Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate14</td><td>Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate15</td><td>Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate16</td><td>Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate17</td><td>Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate18</td><td>Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate19</td><td>Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate20</td><td>Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate21</td><td>Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate22</td><td>Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate23</td><td>Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate24</td><td>Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate25</td><td>Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate26</td><td>Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate27</td><td>Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate28</td><td>Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate29</td><td>Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate30</td><td>Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate31</td><td>Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate32</td><td>Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate33</td><td>Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate34</td><td>Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate35</td><td>Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate36</td><td>Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate37</td><td>Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate38</td><td>Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate39</td><td>Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate40</td><td>Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate41</td><td>Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate42</td><td>Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate43</td><td>Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate44</td><td>Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate45</td><td>Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate46</td><td>Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate47</td><td>Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate48</td><td>Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate49</td><td>Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate50</td><td>Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate51</td><td>Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate52</td><td>Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate53</td><td>Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate54</td><td>Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate55</td><td>Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate56</td><td>Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate57</td><td>Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate58</td><td>Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate59</td><td>Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate60</td><td>Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate61</td><td>Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate62</td><td>Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate63</td><td>Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate64</td><td>Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate65</td><td>Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate66</td><td>Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate67</td><td>Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate68</td><td>Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate69</td><td>Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate70</td><td>Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate71</td><td>Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate72</td><td>Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate73</td><td>Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate74</td><td>Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate75</td><td>Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate76</td><td>Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate77</td><td>Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate78</td><td>Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate79</td><td>Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate80</td><td>Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate81</td><td>Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate82</td><td>Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate83</td><td>Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate84</td><td>Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate85</td><td>Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate86</td><td>Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate87</td><td>Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate88</td><td>Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate89</td><td>Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate90</td><td>Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate91</td><td>Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate92</td><td>Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate93</td><td>Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate94</td><td>Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate95</td><td>Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate96</td><td>Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate97</td><td>Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate98</td><td>Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate99</td><td>Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate00</td><td>死差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate01</td><td>死差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate02</td><td>死差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate03</td><td>死差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate04</td><td>死差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate05</td><td>死差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate06</td><td>死差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate07</td><td>死差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate08</td><td>死差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate09</td><td>死差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate10</td><td>死差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate11</td><td>死差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate12</td><td>死差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate13</td><td>死差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate14</td><td>死差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate15</td><td>死差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate16</td><td>死差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate17</td><td>死差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate18</td><td>死差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate19</td><td>死差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate20</td><td>死差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate21</td><td>死差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate22</td><td>死差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate23</td><td>死差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate24</td><td>死差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate25</td><td>死差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate26</td><td>死差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate27</td><td>死差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate28</td><td>死差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate29</td><td>死差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate30</td><td>死差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate31</td><td>死差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate32</td><td>死差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate33</td><td>死差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate34</td><td>死差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate35</td><td>死差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate36</td><td>死差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate37</td><td>死差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate38</td><td>死差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate39</td><td>死差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate40</td><td>死差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate41</td><td>死差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate42</td><td>死差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate43</td><td>死差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate44</td><td>死差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate45</td><td>死差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate46</td><td>死差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate47</td><td>死差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate48</td><td>死差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate49</td><td>死差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate50</td><td>死差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate51</td><td>死差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate52</td><td>死差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate53</td><td>死差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate54</td><td>死差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate55</td><td>死差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate56</td><td>死差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate57</td><td>死差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate58</td><td>死差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate59</td><td>死差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate60</td><td>死差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate61</td><td>死差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate62</td><td>死差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate63</td><td>死差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate64</td><td>死差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate65</td><td>死差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate66</td><td>死差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate67</td><td>死差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate68</td><td>死差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate69</td><td>死差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate70</td><td>死差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate71</td><td>死差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate72</td><td>死差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate73</td><td>死差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate74</td><td>死差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate75</td><td>死差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate76</td><td>死差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate77</td><td>死差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate78</td><td>死差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate79</td><td>死差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate80</td><td>死差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate81</td><td>死差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate82</td><td>死差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate83</td><td>死差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate84</td><td>死差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate85</td><td>死差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate86</td><td>死差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate87</td><td>死差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate88</td><td>死差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate89</td><td>死差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate90</td><td>死差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate91</td><td>死差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate92</td><td>死差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate93</td><td>死差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate94</td><td>死差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate95</td><td>死差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate96</td><td>死差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate97</td><td>死差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate98</td><td>死差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisadrate99</td><td>死差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate00</td><td>利差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate01</td><td>利差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate02</td><td>利差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate03</td><td>利差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate04</td><td>利差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate05</td><td>利差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate06</td><td>利差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate07</td><td>利差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate08</td><td>利差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate09</td><td>利差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate10</td><td>利差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate11</td><td>利差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate12</td><td>利差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate13</td><td>利差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate14</td><td>利差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate15</td><td>利差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate16</td><td>利差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate17</td><td>利差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate18</td><td>利差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate19</td><td>利差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate20</td><td>利差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate21</td><td>利差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate22</td><td>利差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate23</td><td>利差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate24</td><td>利差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate25</td><td>利差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate26</td><td>利差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate27</td><td>利差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate28</td><td>利差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate29</td><td>利差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate30</td><td>利差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate31</td><td>利差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate32</td><td>利差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate33</td><td>利差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate34</td><td>利差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate35</td><td>利差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate36</td><td>利差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate37</td><td>利差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate38</td><td>利差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate39</td><td>利差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate40</td><td>利差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate41</td><td>利差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate42</td><td>利差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate43</td><td>利差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate44</td><td>利差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate45</td><td>利差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate46</td><td>利差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate47</td><td>利差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate48</td><td>利差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate49</td><td>利差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate50</td><td>利差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate51</td><td>利差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate52</td><td>利差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate53</td><td>利差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate54</td><td>利差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate55</td><td>利差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate56</td><td>利差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate57</td><td>利差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate58</td><td>利差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate59</td><td>利差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate60</td><td>利差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate61</td><td>利差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate62</td><td>利差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate63</td><td>利差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate64</td><td>利差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate65</td><td>利差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate66</td><td>利差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate67</td><td>利差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate68</td><td>利差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate69</td><td>利差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate70</td><td>利差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate71</td><td>利差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate72</td><td>利差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate73</td><td>利差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate74</td><td>利差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate75</td><td>利差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate76</td><td>利差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate77</td><td>利差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate78</td><td>利差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate79</td><td>利差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate80</td><td>利差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate81</td><td>利差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate82</td><td>利差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate83</td><td>利差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate84</td><td>利差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate85</td><td>利差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate86</td><td>利差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate87</td><td>利差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate88</td><td>利差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate89</td><td>利差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate90</td><td>利差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate91</td><td>利差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate92</td><td>利差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate93</td><td>利差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate94</td><td>利差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate95</td><td>利差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate96</td><td>利差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate97</td><td>利差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate98</td><td>利差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>risadrate99</td><td>利差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate00</td><td>費差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate01</td><td>費差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate02</td><td>費差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate03</td><td>費差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate04</td><td>費差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate05</td><td>費差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate06</td><td>費差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate07</td><td>費差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate08</td><td>費差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate09</td><td>費差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate10</td><td>費差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate11</td><td>費差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate12</td><td>費差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate13</td><td>費差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate14</td><td>費差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate15</td><td>費差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate16</td><td>費差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate17</td><td>費差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate18</td><td>費差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate19</td><td>費差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate20</td><td>費差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate21</td><td>費差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate22</td><td>費差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate23</td><td>費差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate24</td><td>費差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate25</td><td>費差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate26</td><td>費差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate27</td><td>費差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate28</td><td>費差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate29</td><td>費差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate30</td><td>費差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate31</td><td>費差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate32</td><td>費差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate33</td><td>費差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate34</td><td>費差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate35</td><td>費差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate36</td><td>費差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate37</td><td>費差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate38</td><td>費差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate39</td><td>費差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate40</td><td>費差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate41</td><td>費差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate42</td><td>費差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate43</td><td>費差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate44</td><td>費差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate45</td><td>費差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate46</td><td>費差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate47</td><td>費差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate48</td><td>費差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate49</td><td>費差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate50</td><td>費差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate51</td><td>費差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate52</td><td>費差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate53</td><td>費差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate54</td><td>費差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate55</td><td>費差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate56</td><td>費差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate57</td><td>費差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate58</td><td>費差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate59</td><td>費差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate60</td><td>費差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate61</td><td>費差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate62</td><td>費差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate63</td><td>費差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate64</td><td>費差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate65</td><td>費差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate66</td><td>費差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate67</td><td>費差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate68</td><td>費差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate69</td><td>費差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate70</td><td>費差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate71</td><td>費差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate72</td><td>費差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate73</td><td>費差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate74</td><td>費差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate75</td><td>費差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate76</td><td>費差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate77</td><td>費差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate78</td><td>費差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate79</td><td>費差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate80</td><td>費差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate81</td><td>費差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate82</td><td>費差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate83</td><td>費差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate84</td><td>費差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate85</td><td>費差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate86</td><td>費差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate87</td><td>費差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate88</td><td>費差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate89</td><td>費差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate90</td><td>費差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate91</td><td>費差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate92</td><td>費差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate93</td><td>費差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate94</td><td>費差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate95</td><td>費差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate96</td><td>費差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate97</td><td>費差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate98</td><td>費差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hisadrate99</td><td>費差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate00</td><td>Ｄ用Ｖレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate01</td><td>Ｄ用Ｖレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate02</td><td>Ｄ用Ｖレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate03</td><td>Ｄ用Ｖレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate04</td><td>Ｄ用Ｖレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate05</td><td>Ｄ用Ｖレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate06</td><td>Ｄ用Ｖレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate07</td><td>Ｄ用Ｖレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate08</td><td>Ｄ用Ｖレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate09</td><td>Ｄ用Ｖレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate10</td><td>Ｄ用Ｖレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate11</td><td>Ｄ用Ｖレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate12</td><td>Ｄ用Ｖレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate13</td><td>Ｄ用Ｖレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate14</td><td>Ｄ用Ｖレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate15</td><td>Ｄ用Ｖレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate16</td><td>Ｄ用Ｖレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate17</td><td>Ｄ用Ｖレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate18</td><td>Ｄ用Ｖレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate19</td><td>Ｄ用Ｖレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate20</td><td>Ｄ用Ｖレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate21</td><td>Ｄ用Ｖレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate22</td><td>Ｄ用Ｖレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate23</td><td>Ｄ用Ｖレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate24</td><td>Ｄ用Ｖレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate25</td><td>Ｄ用Ｖレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate26</td><td>Ｄ用Ｖレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate27</td><td>Ｄ用Ｖレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate28</td><td>Ｄ用Ｖレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate29</td><td>Ｄ用Ｖレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate30</td><td>Ｄ用Ｖレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate31</td><td>Ｄ用Ｖレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate32</td><td>Ｄ用Ｖレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate33</td><td>Ｄ用Ｖレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate34</td><td>Ｄ用Ｖレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate35</td><td>Ｄ用Ｖレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate36</td><td>Ｄ用Ｖレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate37</td><td>Ｄ用Ｖレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate38</td><td>Ｄ用Ｖレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate39</td><td>Ｄ用Ｖレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate40</td><td>Ｄ用Ｖレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate41</td><td>Ｄ用Ｖレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate42</td><td>Ｄ用Ｖレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate43</td><td>Ｄ用Ｖレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate44</td><td>Ｄ用Ｖレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate45</td><td>Ｄ用Ｖレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate46</td><td>Ｄ用Ｖレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate47</td><td>Ｄ用Ｖレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate48</td><td>Ｄ用Ｖレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate49</td><td>Ｄ用Ｖレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate50</td><td>Ｄ用Ｖレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate51</td><td>Ｄ用Ｖレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate52</td><td>Ｄ用Ｖレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate53</td><td>Ｄ用Ｖレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate54</td><td>Ｄ用Ｖレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate55</td><td>Ｄ用Ｖレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate56</td><td>Ｄ用Ｖレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate57</td><td>Ｄ用Ｖレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate58</td><td>Ｄ用Ｖレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate59</td><td>Ｄ用Ｖレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate60</td><td>Ｄ用Ｖレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate61</td><td>Ｄ用Ｖレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate62</td><td>Ｄ用Ｖレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate63</td><td>Ｄ用Ｖレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate64</td><td>Ｄ用Ｖレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate65</td><td>Ｄ用Ｖレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate66</td><td>Ｄ用Ｖレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate67</td><td>Ｄ用Ｖレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate68</td><td>Ｄ用Ｖレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate69</td><td>Ｄ用Ｖレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate70</td><td>Ｄ用Ｖレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate71</td><td>Ｄ用Ｖレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate72</td><td>Ｄ用Ｖレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate73</td><td>Ｄ用Ｖレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate74</td><td>Ｄ用Ｖレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate75</td><td>Ｄ用Ｖレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate76</td><td>Ｄ用Ｖレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate77</td><td>Ｄ用Ｖレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate78</td><td>Ｄ用Ｖレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate79</td><td>Ｄ用Ｖレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate80</td><td>Ｄ用Ｖレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate81</td><td>Ｄ用Ｖレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate82</td><td>Ｄ用Ｖレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate83</td><td>Ｄ用Ｖレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate84</td><td>Ｄ用Ｖレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate85</td><td>Ｄ用Ｖレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate86</td><td>Ｄ用Ｖレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate87</td><td>Ｄ用Ｖレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate88</td><td>Ｄ用Ｖレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate89</td><td>Ｄ用Ｖレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate90</td><td>Ｄ用Ｖレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate91</td><td>Ｄ用Ｖレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate92</td><td>Ｄ用Ｖレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate93</td><td>Ｄ用Ｖレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate94</td><td>Ｄ用Ｖレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate95</td><td>Ｄ用Ｖレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate96</td><td>Ｄ用Ｖレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate97</td><td>Ｄ用Ｖレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate98</td><td>Ｄ用Ｖレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate99</td><td>Ｄ用Ｖレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate00</td><td>危険Ｓレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate01</td><td>危険Ｓレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate02</td><td>危険Ｓレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate03</td><td>危険Ｓレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate04</td><td>危険Ｓレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate05</td><td>危険Ｓレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate06</td><td>危険Ｓレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate07</td><td>危険Ｓレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate08</td><td>危険Ｓレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate09</td><td>危険Ｓレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate10</td><td>危険Ｓレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate11</td><td>危険Ｓレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate12</td><td>危険Ｓレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate13</td><td>危険Ｓレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate14</td><td>危険Ｓレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate15</td><td>危険Ｓレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate16</td><td>危険Ｓレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate17</td><td>危険Ｓレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate18</td><td>危険Ｓレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate19</td><td>危険Ｓレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate20</td><td>危険Ｓレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate21</td><td>危険Ｓレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate22</td><td>危険Ｓレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate23</td><td>危険Ｓレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate24</td><td>危険Ｓレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate25</td><td>危険Ｓレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate26</td><td>危険Ｓレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate27</td><td>危険Ｓレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate28</td><td>危険Ｓレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate29</td><td>危険Ｓレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate30</td><td>危険Ｓレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate31</td><td>危険Ｓレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate32</td><td>危険Ｓレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate33</td><td>危険Ｓレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate34</td><td>危険Ｓレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate35</td><td>危険Ｓレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate36</td><td>危険Ｓレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate37</td><td>危険Ｓレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate38</td><td>危険Ｓレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate39</td><td>危険Ｓレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate40</td><td>危険Ｓレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate41</td><td>危険Ｓレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate42</td><td>危険Ｓレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate43</td><td>危険Ｓレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate44</td><td>危険Ｓレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate45</td><td>危険Ｓレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate46</td><td>危険Ｓレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate47</td><td>危険Ｓレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate48</td><td>危険Ｓレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate49</td><td>危険Ｓレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate50</td><td>危険Ｓレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate51</td><td>危険Ｓレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate52</td><td>危険Ｓレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate53</td><td>危険Ｓレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate54</td><td>危険Ｓレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate55</td><td>危険Ｓレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate56</td><td>危険Ｓレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate57</td><td>危険Ｓレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate58</td><td>危険Ｓレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate59</td><td>危険Ｓレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate60</td><td>危険Ｓレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate61</td><td>危険Ｓレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate62</td><td>危険Ｓレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate63</td><td>危険Ｓレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate64</td><td>危険Ｓレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate65</td><td>危険Ｓレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate66</td><td>危険Ｓレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate67</td><td>危険Ｓレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate68</td><td>危険Ｓレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate69</td><td>危険Ｓレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate70</td><td>危険Ｓレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate71</td><td>危険Ｓレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate72</td><td>危険Ｓレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate73</td><td>危険Ｓレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate74</td><td>危険Ｓレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate75</td><td>危険Ｓレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate76</td><td>危険Ｓレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate77</td><td>危険Ｓレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate78</td><td>危険Ｓレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate79</td><td>危険Ｓレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate80</td><td>危険Ｓレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate81</td><td>危険Ｓレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate82</td><td>危険Ｓレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate83</td><td>危険Ｓレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate84</td><td>危険Ｓレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate85</td><td>危険Ｓレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate86</td><td>危険Ｓレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate87</td><td>危険Ｓレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate88</td><td>危険Ｓレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate89</td><td>危険Ｓレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate90</td><td>危険Ｓレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate91</td><td>危険Ｓレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate92</td><td>危険Ｓレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate93</td><td>危険Ｓレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate94</td><td>危険Ｓレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate95</td><td>危険Ｓレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate96</td><td>危険Ｓレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate97</td><td>危険Ｓレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate98</td><td>危険Ｓレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kikensrate99</td><td>危険Ｓレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateD
 * @see     GenBM_RateD
 * @see     QBM_RateD
 * @see     GenQBM_RateD
 */
public class PKBM_RateD extends AbstractExDBPrimaryKey<BM_RateD, PKBM_RateD> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateD() {
    }

    public PKBM_RateD(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        palhokensyuruikigou = pPalhokensyuruikigou;
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
        palyoteiriritu = pPalyoteiriritu;
        palpmencode = pPalpmencode;
        palharaikomikaisuu = pPalharaikomikaisuu;
        palhhknsei = pPalhhknsei;
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
        palsaimankihyouji = pPalsaimankihyouji;
        palhokenkikan = pPalhokenkikan;
        palpharaikomikikan = pPalpharaikomikikan;
        paldnendo = pPaldnendo;
        paldratenaikakucode = pPaldratenaikakucode;
    }

    @Transient
    @Override
    public Class<BM_RateD> getEntityClass() {
        return BM_RateD.class;
    }

    private String palhokensyuruikigou;

    public String getPalhokensyuruikigou() {
        return palhokensyuruikigou;
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        palhokensyuruikigou = pPalhokensyuruikigou;
    }
    private String palhokensyuruikigousdicode;

    public String getPalhokensyuruikigousdicode() {
        return palhokensyuruikigousdicode;
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
    }
    private String palyoteiriritu;

    public String getPalyoteiriritu() {
        return palyoteiriritu;
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        palyoteiriritu = pPalyoteiriritu;
    }
    private String palpmencode;

    public String getPalpmencode() {
        return palpmencode;
    }

    public void setPalpmencode(String pPalpmencode) {
        palpmencode = pPalpmencode;
    }
    private String palharaikomikaisuu;

    public String getPalharaikomikaisuu() {
        return palharaikomikaisuu;
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        palharaikomikaisuu = pPalharaikomikaisuu;
    }
    private String palhhknsei;

    public String getPalhhknsei() {
        return palhhknsei;
    }

    public void setPalhhknsei(String pPalhhknsei) {
        palhhknsei = pPalhhknsei;
    }
    private String palkeiyakujihhknnen;

    public String getPalkeiyakujihhknnen() {
        return palkeiyakujihhknnen;
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
    }
    private String palsaimankihyouji;

    public String getPalsaimankihyouji() {
        return palsaimankihyouji;
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        palsaimankihyouji = pPalsaimankihyouji;
    }
    private String palhokenkikan;

    public String getPalhokenkikan() {
        return palhokenkikan;
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        palhokenkikan = pPalhokenkikan;
    }
    private String palpharaikomikikan;

    public String getPalpharaikomikikan() {
        return palpharaikomikikan;
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        palpharaikomikikan = pPalpharaikomikikan;
    }
    private String paldnendo;

    public String getPaldnendo() {
        return paldnendo;
    }

    public void setPaldnendo(String pPaldnendo) {
        paldnendo = pPaldnendo;
    }
    private String paldratenaikakucode;

    public String getPaldratenaikakucode() {
        return paldratenaikakucode;
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        paldratenaikakucode = pPaldratenaikakucode;
    }

}