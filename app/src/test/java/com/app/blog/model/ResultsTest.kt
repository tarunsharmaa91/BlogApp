package com.app.blog.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ResultsTest {
    private val id = 15
    private val body = "body text"
    private val name = "post title"
    private val uid = 78624

    @Mock
    var results: Results? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(results!!.id).thenReturn(id)
        Mockito.`when`(results!!.body).thenReturn(body)
        Mockito.`when`(results!!.title).thenReturn(name)
        Mockito.`when`(results!!.userId).thenReturn(uid)
    }

    @Test
    fun testName() {
        Mockito.`when`(results!!.title).thenReturn(name)
        Assert.assertEquals("post title", results!!.title)
    }

    @Test
    fun testBody() {
        Mockito.`when`(results!!.body).thenReturn(body)
        Assert.assertEquals("body text", results!!.body)
    }

    @Test
    fun testUserId() {
        Mockito.`when`(results!!.userId).thenReturn(uid)
        Assert.assertEquals(78624, results!!.userId.toLong())
    }

    @Test
    fun testId() {
        Mockito.`when`(results!!.id).thenReturn(id)
        Assert.assertEquals(15, results!!.id.toLong())
    }
}