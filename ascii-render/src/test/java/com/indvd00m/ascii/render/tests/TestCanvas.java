package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.api.ICanvas;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestCanvas {

	@Test
	public void test01() {
		ICanvas canvas = new Canvas(10, 5);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(0, 1, '1');
		s = "";
		s += "          \n";
		s += "1         \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(0, 1, "123");
		s = "";
		s += "          \n";
		s += "123       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(8, 0, "12345");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(4, 2, "line1\nline2\nline3");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    line1 \n";
		s += "    line2 \n";
		s += "    line3 ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(6, 2, "1line\n2line\n3line");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li3lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(6, 4, "1line\n2line\n3line");
		s = "";
		s += "        12\n";
		s += "123       \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(5, 1, '1', 3);
		s = "";
		s += "        12\n";
		s += "123  111  \n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.draw(5, 1, "12", 3);
		s = "";
		s += "        12\n";
		s += "123  12121\n";
		s += "    li1lin\n";
		s += "    li2lin\n";
		s += "    li1lin";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
		assertEquals(0, canvas.getChar(0, -1));
		assertEquals(0, canvas.getChar(-1, 0));
		assertEquals(0, canvas.getChar(canvas.getWidth(), 0));
		assertEquals(0, canvas.getChar(0, canvas.getHeight()));
		assertEquals('1', canvas.getChar(0, 1));
		assertEquals('i', canvas.getChar(5, 2));
	}

	@Test
	public void test02() {
		ICanvas canvas = new Canvas(10, 5);
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test03() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(2, 2, "****");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "  ****    \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "****";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test04() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(3, 1, "1");
		canvas.draw(2, 2, "****");
		canvas.draw(7, 3, "3");
		String s = "";
		s += "          \n";
		s += "   1      \n";
		s += "  ****    \n";
		s += "       3  \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += " 1    \n";
		t += "****  \n";
		t += "     3";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test05() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(1, 0, "1");
		canvas.draw(2, 2, "****");
		canvas.draw(4, 3, "3");
		String s = "";
		s += " 1        \n";
		s += "          \n";
		s += "  ****    \n";
		s += "    3     \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "1    \n";
		t += "     \n";
		t += " ****\n";
		t += "   3 ";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test06() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(4, 0, "*");
		canvas.draw(2, 1, "1");
		canvas.draw(2, 2, "****");
		canvas.draw(4, 3, "3");
		canvas.draw(1, 4, "2");
		String s = "";
		s += "    *     \n";
		s += "  1       \n";
		s += "  ****    \n";
		s += "    3     \n";
		s += " 2        ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "   * \n";
		t += " 1   \n";
		t += " ****\n";
		t += "   3 \n";
		t += "2    ";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test07() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(0, 0, "*");
		canvas.draw(9, 0, "*");
		canvas.draw(2, 1, "1");
		canvas.draw(2, 2, "****");
		canvas.draw(4, 3, "3");
		canvas.draw(0, 4, "*");
		canvas.draw(9, 4, "*");
		String s = "";
		s += "*        *\n";
		s += "  1       \n";
		s += "  ****    \n";
		s += "    3     \n";
		s += "*        *";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*        *\n";
		t += "  1       \n";
		t += "  ****    \n";
		t += "    3     \n";
		t += "*        *";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test08() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(9, 2, "*");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "         *\n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test09() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(9, 2, "*");
		canvas.draw(9, 3, "*");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "         *\n";
		s += "         *\n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*\n";
		t += "*";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test10() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(5, 4, "*");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "     *    ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test11() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(5, 4, "**");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "     **   ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "**";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	@Test
	public void test12() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(0, 2, "*");
		String s = "";
		s += "          \n";
		s += "          \n";
		s += "*         \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

	public void test13() {
		ICanvas canvas = new Canvas(10, 5);
		canvas.draw(5, 0, "*");
		String s = "";
		s += "     *    \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());

		ICanvas trimmed = canvas.trim();
		String t = "";
		t += "*";
		System.out.println(trimmed.getText());

		assertEquals(s, canvas.getText());
		assertEquals(t, trimmed.getText());
	}

}
