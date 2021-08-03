package com.app.blog.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CommentsTest {
    private val postId = 15
    private val id = 15
    private val body = "body text"
    private val name = "post title"
    private val email = "t@g.co"

    @Mock
    var results: Comments? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(results!!.postId).thenReturn(postId)
        Mockito.`when`(results!!.id).thenReturn(id)
        Mockito.`when`(results!!.body).thenReturn(body)
        Mockito.`when`(results!!.name).thenReturn(name)
        Mockito.`when`(results!!.email).thenReturn(email)
    }

    @Test
    fun testPostId() {
        Mockito.`when`(results!!.postId).thenReturn(postId)
        Assert.assertEquals(15, results!!.postId)
    }

    @Test
    fun testId() {
        Mockito.`when`(results!!.id).thenReturn(id)
        Assert.assertEquals(15, results!!.id)
    }

    @Test
    fun testBody() {
        Mockito.`when`(results!!.body).thenReturn(body)
        Assert.assertEquals("body text", results!!.body)
    }

    @Test
    fun testName() {
        Mockito.`when`(results!!.name).thenReturn(name)
        Assert.assertEquals("post title", results!!.name)
    }

    @Test
    fun testEmail() {
        Mockito.`when`(results!!.email).thenReturn(email)
        Assert.assertEquals("t@g.co", results!!.email)
    }
}